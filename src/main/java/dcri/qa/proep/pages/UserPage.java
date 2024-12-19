package dcri.qa.proep.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dcri.qa.proep.constants.AppConstants;
import dcri.qa.proep.utils.ElementUtil;
import dcri.qa.proep.utils.JavaScriptUtil;

public class UserPage {

	 private WebDriver driver;
	    private ElementUtil eleUtil;
	    private JavaScriptUtil jsUtil;
	    
	 // Locators
	    private By userTab = By.xpath("//div[contains(text(),'User')]");
	    private By addUserButton = By.id("add-user");
	    private By entryFormUser = By.cssSelector("app-user-form#create-user-form");
	    private By MainTab = By.xpath("//div[@class='mat-mdc-tab-labels']//span[contains(text(), 'Main') and @class='ng-star-inserted invalid-emphasis']");
	    
	    private By firstNameInput = By.xpath(".//input[@name='First Name']");
	    private By lastNameInput = By.xpath(".//input[@name='Last Name']");
	    private By roleSelect = By.xpath(".//mat-form-field[.//mat-label[text()='Role']]//mat-select");
	    private By interviewerOption = By.xpath("//span[contains(text(),'Interviewer')]");
	    private By employmentStatusSelect = By.xpath(".//mat-form-field[.//mat-label[text()='Employment Status']]//mat-select");
	    private By permanentOption = By.xpath("//div[contains(@class,'cdk-overlay-pane')]//mat-option//span[normalize-space()='Permanent']");
	    private By schedulingLevelSelect = By.xpath(".//mat-form-field[.//mat-label[text()='Scheduling Level']]//mat-select");
	    private By schedulingLevelOption = By.xpath("//span[contains(text(),'Level 3 - No Validation')]");

	    private By employeeContactInfoTab = By.xpath("//div[@class='mat-mdc-tab-labels']//span[contains(text(), 'Employee Contact Info') and @class='ng-star-inserted invalid-emphasis']");
	    private By netIDInput = By.xpath(".//input[@name='Net ID']");
	    private By uniqueIDInput = By.xpath(".//input[@name='Unique ID']");
	    private By workEmailInput = By.xpath(".//input[@name='Work Email']");
	    private By calendarButton = By.xpath(".//button//span[@class='mat-mdc-button-touch-target']");
	    private By calendarDate = By.xpath("//span[normalize-space()='1']");

	    private By personalContactInfoTabXPath = By.xpath("//div[@class='mat-mdc-tab-labels']//div[@role='tab']//span[contains(@class, 'ng-star-inserted') and text()='Personal Contact Info']");

	    private By homeEmailInput = By.xpath(".//input[@name='Home Email']");
	    private By homePhoneInput = By.xpath(".//input[@name='Home Phone']");
	    private By primaryEmergencyContactNameInput = By.xpath(".//input[@name='Primary Emergency Contact Name']");
	    private By primaryEmergencyContactNumberInput = By.xpath(".//input[@name='Primary Emergency Contact Number']");
	    private By primaryEmergencyContactRelationshipInput = By.xpath(".//input[@name='Primary Emergency Contact Relationship']");
	    private By homeAddressInput = By.xpath(".//input[@name='Home Address']");
	    private By cityInput = By.xpath(".//input[@name='City']");
	    private By stateSelect = By.xpath(".//mat-form-field[.//mat-label[text()='State']]//mat-select");
	    private By northCarolinaOption = By.xpath("//span[contains(text(),'North Carolina')]");
	    private By zipCodeInput = By.xpath(".//input[@name='Zip Code']");
	    private By userProfileButtons = By.id("user-profile-buttons");
	    private By popupButtons = By.id("popup-buttons");
	    
	    public UserPage(WebDriver driver) {
	        this.driver = driver;
	        this.eleUtil = new ElementUtil(driver);
	        this.jsUtil = new JavaScriptUtil(driver);
	    }
	    
	    public void createUser() {
	        // Navigate to User tab and click
	        eleUtil.waitForElementVisible(userTab, 10).click();

	        // Click Add User
	        eleUtil.waitForElementVisible(addUserButton, 10).click();

	        // Wait for entry form visible and get the entry form element
	        WebElement entryFormEl = eleUtil.waitForElementVisible(entryFormUser, 10);
	        
	        // Main Tab
	        
	        eleUtil.waitForElementVisible(MainTab, 10).click();
	        
	         Actions actions = new Actions(driver);
			
			 actions.sendKeys(Keys.TAB).build().perform();
			 actions.sendKeys(Keys.SPACE).build().perform();

	      
	        
	        // Fill First Name
	        WebElement firstNameEl = entryFormEl.findElement(firstNameInput);
	        firstNameEl.clear();
	        firstNameEl.sendKeys("Testing");

	        // Fill Last Name
	        WebElement lastNameEl = entryFormEl.findElement(lastNameInput);
	        lastNameEl.clear();
	        lastNameEl.sendKeys("OQ");

	        // Select Role as "Interviewer"
	        WebElement roleSelectEl = entryFormEl.findElement(roleSelect);
	        roleSelectEl.click();
	        eleUtil.waitForElementToBeClickable(10, interviewerOption).click();

	        // Select Employment Status as "Permanent"
	        WebElement employmentStatusSelectEl = entryFormEl.findElement(employmentStatusSelect);
	        employmentStatusSelectEl.click();
	        eleUtil.waitForElementToBeClickable(10, permanentOption).click();

	        // Select Scheduling Level
	        WebElement schedulingLevelSelectEl = entryFormEl.findElement(schedulingLevelSelect);
	        schedulingLevelSelectEl.click();
	        eleUtil.waitForElementToBeClickable(10, schedulingLevelOption).click();

	        // Employment Contact Info tab
	        eleUtil.waitForElementVisible(employeeContactInfoTab, 10).click();

	        // Fill Net ID
	        WebElement netIdEl = entryFormEl.findElement(netIDInput);
	        netIdEl.clear();
	        netIdEl.sendKeys("12345");

	        // Fill Unique ID
	        WebElement uniqueIdEl = entryFormEl.findElement(uniqueIDInput);
	        uniqueIdEl.clear();
	        uniqueIdEl.sendKeys("10000");

	        // Fill Work Email
	        WebElement workEmailEl = entryFormEl.findElement(workEmailInput);
	        workEmailEl.clear();
	        workEmailEl.sendKeys("Testing@duke.edu");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingSpinner")));

	        
	        // Fill Start Date
	        WebElement calendarBtnEl = entryFormEl.findElement(calendarButton);
	        calendarBtnEl.click();
	        
	        eleUtil.hardWait(2);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingSpinner")));
	        
	        eleUtil.waitForElementVisible(calendarDate, 10).click();

	        eleUtil.hardWait(2);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingSpinner")));
	        
	        
	        // Personal Contact Info tab
	        // Try clicking each personal contact info tab element one by one
	        List<WebElement> elements = driver.findElements(personalContactInfoTabXPath);
	        for (WebElement element : elements) {
	            try {
	                new WebDriverWait(driver, Duration.ofSeconds(10))
	                        .until(ExpectedConditions.elementToBeClickable(element)).click();
	                System.out.println("Clicked on Personal Contact Info tab successfully.");
	                break;
	            } catch (Exception e) {
	                System.out.println("Failed to click on this element. Trying next.");
	            }
	        }

	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingSpinner")));
	        
	        // Fill Home Email
	        WebElement homeEmailEl = entryFormEl.findElement(homeEmailInput);
	        homeEmailEl.clear();
	        homeEmailEl.sendKeys("Testing@gmail.com");

	        // Fill Home Phone
	        WebElement homePhoneEl = entryFormEl.findElement(homePhoneInput);
	        homePhoneEl.clear();
	        homePhoneEl.sendKeys("(919) 521-5469");

	        // Fill Primary Emergency Contact Name
	        WebElement primaryNameEl = entryFormEl.findElement(primaryEmergencyContactNameInput);
	        primaryNameEl.clear();
	        primaryNameEl.sendKeys("John Doe");

	        // Primary Emergency Contact Number
	        WebElement primaryNumberEl = entryFormEl.findElement(primaryEmergencyContactNumberInput);
	        primaryNumberEl.clear();
	        primaryNumberEl.sendKeys("(919) 521-5555");

	        // Primary Emergency Contact Relationship
	        WebElement primaryRelEl = entryFormEl.findElement(primaryEmergencyContactRelationshipInput);
	        primaryRelEl.clear();
	        primaryRelEl.sendKeys("Father");

	        // Home Address
	        WebElement homeAddressEl = entryFormEl.findElement(homeAddressInput);
	        homeAddressEl.clear();
	        homeAddressEl.sendKeys("6353 Juan Tabo");

	        // City
	        WebElement cityEl = entryFormEl.findElement(cityInput);
	        cityEl.clear();
	        cityEl.sendKeys("Durham");

	        // Select State
	        WebElement stateSelectEl = entryFormEl.findElement(stateSelect);
	        stateSelectEl.click();
	        eleUtil.waitForElementToBeClickable(10, northCarolinaOption).click();

	        // Zip Code
	        WebElement zipCodeEl = entryFormEl.findElement(zipCodeInput);
	        zipCodeEl.clear();
	        zipCodeEl.sendKeys("27703");
	        zipCodeEl.click();

	        
	        
	        eleUtil.hardWait(2);
	        
	     // click Save Profile
	        
	        
	        
	        entryFormEl = eleUtil.waitForElementVisible(entryFormUser, 10);
	        
	        WebElement userProfileButtons1 = entryFormEl.findElement(userProfileButtons);
	        userProfileButtons1.click();
	        
	        
	        
	        eleUtil.hardWait(2);
	        
	        // Accept Alert
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	        
	        
	        // Click popup button
	   
	        eleUtil.hardWait(2);
	        
		        //WebElement popupButtons1 = entryFormEl.findElement(popupButtons);
		       // popupButtons1.click();
	      
		        eleUtil.waitForElementVisible(popupButtons, 10).click();
	        
	        
	    }
	    
	    

}
