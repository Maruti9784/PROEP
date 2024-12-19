package dcri.qa.proep.tests;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dcri.qa.proep.utils.TOTPGenerator;

public class RoleAccess {

    @Test
    public void Grouper_Access_Admin() throws InterruptedException {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.navigate().to("https://groups.oit.duke.edu/groupmanager/");

        // Maximize the window
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Expand net ID input field using explicit wait
        WebElement expandNetIDButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='expand-netid']")));
        expandNetIDButton.click();

     // Wait for the username field to be visible
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));

        // Scroll into view if necessary (in case it's not visible on the page)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", usernameField);

        // Enter credentials (Username and Password)
        usernameField.sendKeys("svc_automation_qa_01");
        WebElement passwordField = driver.findElement(By.id("j_password"));
        passwordField.sendKeys("Auto_Test#01");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Generate and input TOTP
        String secret = "KK4F2iS5DpnzDjADFUfgdZ9PdqxuSm3HRmBIvskf5Ln2uCHyh8kDXcwYf5ZqodXGuPEUKMVrJuV4fUMCbk6uZiCtXkYEb4xktqgS";
        long currentTime = System.currentTimeMillis() / 1000L;
        String totp = TOTPGenerator.generateTOTP(secret, currentTime);

        WebElement duoPasscodeInput = driver.findElement(By.xpath("//input[@id='duoPasscodeInput']"));
        duoPasscodeInput.click();
        duoPasscodeInput.sendKeys(totp);

        // Submit login
        driver.findElement(By.xpath("//button[@id='Submit']")).click();

        // Wait until the specific element is clickable and click it
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='CCEP_Admin_VAL']")));
        element.click();

        // Search for the NetID
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='member-search-input']"));
        searchInput.sendKeys("svc_automation_qa_01");

        // Locate NetID in the table
        String netId = "svc_automation_qa_01";
        By netIdLocator = By.xpath("//table[@id='members-table']//td[text()='" + netId + "']");
        List<WebElement> netIdElements = driver.findElements(netIdLocator);

        if (!netIdElements.isEmpty()) {
            WebElement netIdElement = netIdElements.get(0);
            if (netIdElement.isDisplayed()) {
                System.out.println("NetID '" + netId + "' is displayed on the page.");
            }
        } else {
            System.out.println("NetID '" + netId + "' is NOT displayed on the page.");
            // If NetID is not found, add it
            driver.findElement(By.xpath("//a[@id='add-member']")).click();

            WebElement addMemberInput = driver.findElement(By.xpath("//input[@id='add-member-input']"));
            addMemberInput.sendKeys("svc_automation_qa_01");
            addMemberInput.sendKeys(Keys.ENTER);
        }

        // If NetID is displayed, select and remove it
        if (!netIdElements.isEmpty()) {
            WebElement checkbox = driver.findElement(By.xpath("//input[@class='remove-member']"));

            if (!checkbox.isSelected()) {
                checkbox.click();
                System.out.println("Checkbox has been selected.");
            } else {
                System.out.println("Checkbox is already selected.");
            }

            // Remove selected members
            driver.findElement(By.xpath("//button[@id='remove-selected-members']")).click();
        }

        // Quit the driver at the end
       // driver.quit();
    }
}
