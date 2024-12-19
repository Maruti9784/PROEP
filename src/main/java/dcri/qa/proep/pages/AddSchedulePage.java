package dcri.qa.proep.pages;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dcri.qa.proep.utils.ElementUtil;
import dcri.qa.proep.utils.JavaScriptUtil;
import dcri.qa.proep.constants.AppConstants;

public class AddSchedulePage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil jsUtil;

    // Locators
    private By addScheduleButton = By.xpath("//div[contains(text(),'Add a Schedule')]");
    private By modalLocator = By.id("schedule-modal");
    private By addButton = By.cssSelector(".add-schedule-row");
    private By scheduleLine = By.cssSelector("app-schedule-line");
    private By userDropdown = By.xpath(".//mat-form-field[.//mat-label[text()='User']]//mat-select");
    private By userOption = By.xpath("//mat-option//span[contains(text(), 'Maruti Gollar')]");
    private By projectDropdown = By.xpath(".//mat-form-field[.//mat-label[text()='Project']]//mat-select");
    private By datepicker = By.xpath(".//button//span[@class='mat-mdc-button-touch-target']");
    private By calendarTable = By.className("mat-calendar-table");
    private By startTimeDropdownLocator = By.xpath(".//mat-form-field[.//mat-label[text()='Start Time']]//mat-select");
    private By endTimeDropdownLocator = By.xpath(".//mat-form-field[.//mat-label[text()='End Time']]//mat-select");
    private By saveAllButton = By.id("schedule-save-all-button");
    private By successMsgButton = By.xpath("//button[@id='profile-save-button']");

    public AddSchedulePage(WebDriver driver) {
        this.driver = driver;
        this.eleUtil = new ElementUtil(driver);
        this.jsUtil = new JavaScriptUtil(driver);
    }

    public void addScheduleEntries() {
        // Click on 'Add a Schedule' button and wait for the modal to appear
    	eleUtil.waitForElementVisible(addScheduleButton, 10).click();
        eleUtil.waitForElementVisible(modalLocator, 10);

        // Define test data
        List<String> dates = Arrays.asList("21", "22", "23", "24", "25", "26", "27");
        List<String> projects = Arrays.asList("ACTIV 6", "ARAMIS", "BEST Registry", "CARRA", "HEAL SKOAP", "HERO Together Boost", "PREVENTABLE");
        List<String> startTimes = Arrays.asList("09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM");
        List<String> endTimes = Arrays.asList("05:00 PM", "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM", "10:00 PM", "11:00 PM");

        for (int i = 0; i < 5; i++) {
            if (i > 0) {
                // Click 'Add' to add a new schedule line and wait for it to appear
                eleUtil.doClick(addButton);
                eleUtil.waitForElementVisible(scheduleLine, 10);
            }

            // Retrieve all schedule lines and select the current one
            List<WebElement> scheduleLines = eleUtil.getElements(scheduleLine);
            WebElement scheduleForm = scheduleLines.get(i);

            // Select User
            WebElement userDd = scheduleForm.findElement(userDropdown);
            eleUtil.doClick(userDd);
            eleUtil.waitForElementToBeClickable(10, userOption);
            eleUtil.doClick(userOption);

            // Select Project
            WebElement projectDd = scheduleForm.findElement(projectDropdown);
            eleUtil.doClick(projectDd);
            By projectOptionLocator = By.xpath("//mat-option//span[contains(text(), '" + projects.get(i) + "')]");
            eleUtil.waitForElementToBeClickable(10, projectOptionLocator);
            eleUtil.doClick(projectOptionLocator);
            
            // Select Date
            WebElement datePickerBtn = scheduleForm.findElement(datepicker);
            eleUtil.doClick(datePickerBtn);
            eleUtil.waitForElementVisible(calendarTable, 10);
            By dateLocator = By.xpath("//span[normalize-space()='" + dates.get(i) + "']");
            eleUtil.waitForElementToBeClickable(10, dateLocator);
            eleUtil.doClick(dateLocator);

            // Select Start Time
            WebElement startTimeDd = scheduleForm.findElement(startTimeDropdownLocator);
            eleUtil.doClick(startTimeDd);
            By startTimeOptionLocator = By.xpath("//mat-option//span[contains(text(), '" + startTimes.get(i) + "')]");
            eleUtil.waitForElementToBeClickable(10, startTimeOptionLocator);
            eleUtil.doClick(startTimeOptionLocator);

            // Select End Time
            WebElement endTimeDd = scheduleForm.findElement(endTimeDropdownLocator);
            eleUtil.doClick(endTimeDd);
            By endTimeOptionLocator = By.xpath("//mat-option//span[contains(text(), '" + endTimes.get(i) + "')]");
            eleUtil.waitForElementToBeClickable(10, endTimeOptionLocator);
            eleUtil.doClick(endTimeOptionLocator);
        }

        // Save all schedules
       
        eleUtil.waitForElementVisible(saveAllButton, 10).click();

        // Wait for success message and click it
        eleUtil.waitForElementVisible(successMsgButton, 10).click();
    }
}
