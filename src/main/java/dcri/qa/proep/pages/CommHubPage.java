package dcri.qa.proep.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dcri.qa.proep.utils.ElementUtil;
import dcri.qa.proep.utils.JavaScriptUtil;

public class CommHubPage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil jsUtil;

    // Locators
    private By communicationsHubLink = By.xpath("//div[contains(text(),'Communications Hub')]");
    private By projectDropdown = By.id("mat-select-36");
    private By projectOptionTesting = By.xpath("//span[normalize-space()='Testing']");
    private By addButton = By.id("comm-hub-add-button");
    private By modalPopup = By.cssSelector("app-modal-popup");

    // Entry Form Locators
    private By studyNumberInput = By.name("Study Number");
    private By firstNameInput = By.name("First Name");
    private By lastNameInput = By.name("Last Name");
    private By emailInput = By.name("Email");
    private By emailConfirmInput = By.name("Email-confirm");
    private By cellInput = By.name("Cell #");
    private By cellConfirmInput = By.name("Cell #-confirm");
    private By homeInput = By.name("Home #");
    private By homeConfirmInput = By.name("Home #-confirm");
    private By workInput = By.name("Work #");
    private By workConfirmInput = By.name("Work #-confirm");
    private By formTopicDropdown = By.xpath(".//mat-form-field[.//mat-label[text()='Form/Topic']]//mat-select");
    private By formTopicOption = By.xpath("//span[normalize-space()='TBD 1']");
    private By datepickerButton = By.xpath(".//button//span[@class='mat-mdc-button-touch-target']");
    private By dateLocator = By.xpath("//span[normalize-space()='25']");
    private By hoursInput = By.name("Call Start Date-hours");
    private By minutesInput = By.name("Call Start Date-minutes");
    private By amPmDropdown = By.xpath(".//mat-form-field[.//mat-label[text()='AM/PM']]//mat-select");
    private By amOption = By.xpath("//span[normalize-space()='AM']");
    private By methodOfCommunicationDropdown = By.xpath(".//mat-form-field[.//mat-label[text()='Method of Communication']]//mat-select");
    private By methodOfCommunicationOption = By.xpath("//span[normalize-space()='Call']");
    private By communicationDetailsInput = By.name("Communication Details");
    private By whoCompletedInterviewInput = By.name("Who completed interview");
    private By yoFieldInput = By.name("yo");
    private By saveButton = By.id("comm-hub-save-button");
    private By successMsgButton = By.xpath("//button[@id='profile-save-button']");

    public CommHubPage(WebDriver driver) {
        this.driver = driver;
        this.eleUtil = new ElementUtil(driver);
        this.jsUtil = new JavaScriptUtil(driver);
    }

    // Method to navigate to Communications Hub and select the project
    public void navigateToCommunicationsHub() throws InterruptedException {
        // Navigate to Communications Hub
        eleUtil.doClick(communicationsHubLink);

        // Select Project
        eleUtil.waitForElementVisible(projectDropdown, 10);
        eleUtil.doClick(projectDropdown);
        eleUtil.doClick(projectOptionTesting);
    }

    // Method to fill out the communication entry form using data from parameters
    public void fillCommunicationEntryForm(String studyNumber, String firstName, String lastName,
                                           String email, String confirmEmail, String cell, String confirmCell,
                                           String home, String confirmHome, String work, String confirmWork,
                                           String formTopic, String callStartDate, String hours, String minutes,
                                           String amPm, String methodOfCommunication, String communicationDetail,
                                           String whoCompletedInterview, String yo) throws InterruptedException {
        // Click Add Button
        eleUtil.waitForElementVisible(addButton, 10);
        eleUtil.doClick(addButton);

        // Wait for modal popup
        
        WebElement entryForm = driver.findElement(By.cssSelector("app-modal-popup"));
    	eleUtil.waitForElementVisible(modalPopup, 10);

        // Fill out the form fields
    	entryForm.findElement(studyNumberInput);
        eleUtil.doSendKeys(studyNumberInput, studyNumber);
        entryForm.findElement(firstNameInput);
        eleUtil.doSendKeys(firstNameInput, firstName);
        entryForm.findElement(lastNameInput);
        eleUtil.doSendKeys(lastNameInput, lastName);
        entryForm.findElement(emailInput);
        eleUtil.doSendKeys(emailInput, email);
        entryForm.findElement(emailConfirmInput);
        eleUtil.doSendKeys(emailConfirmInput, confirmEmail);
        entryForm.findElement(cellInput);
        eleUtil.doSendKeys(cellInput, cell);
        entryForm.findElement(cellConfirmInput);
        eleUtil.doSendKeys(cellConfirmInput, confirmCell);
        entryForm.findElement(homeInput);
        eleUtil.doSendKeys(homeInput, home);
        entryForm.findElement(homeConfirmInput);
        eleUtil.doSendKeys(homeConfirmInput, confirmHome);
        entryForm.findElement(workInput);
        eleUtil.doSendKeys(workInput, work);
        entryForm.findElement(workConfirmInput);
        eleUtil.doSendKeys(workConfirmInput, confirmWork);

        // Select Form/Topic
        entryForm.findElement(formTopicDropdown);
        eleUtil.waitForElementToBeClickable(10, formTopicDropdown);
        eleUtil.doClick(formTopicDropdown);
        By formTopicOption = By.xpath("//span[normalize-space()='" + formTopic + "']");
        eleUtil.doClick(formTopicOption);

        // Select Call Start Date
        entryForm.findElement(datepickerButton);
        eleUtil.waitForElementToBeClickable(10, datepickerButton);
        WebElement datepicker = entryForm.findElement(datepickerButton);
        eleUtil.doClick(datepicker);
        eleUtil.waitForElementVisible(By.className("mat-calendar-table"), 10);
        By dateLocator = By.xpath("//span[normalize-space()='" + callStartDate + "']");
        eleUtil.waitForElementToBeClickable(10, dateLocator);
        eleUtil.doClick(dateLocator);
        
        entryForm.findElement(hoursInput);
        eleUtil.waitForElementToBeClickable(10, hoursInput);
        eleUtil.doSendKeys(hoursInput, hours);
        
        entryForm.findElement(minutesInput);
        eleUtil.waitForElementToBeClickable(10, minutesInput);
        eleUtil.doSendKeys(minutesInput, minutes);

        // Select AM/PM
        entryForm.findElement(amPmDropdown);
        eleUtil.waitForElementToBeClickable(10, amPmDropdown);
        eleUtil.doClick(amPmDropdown);
        By amPmOption = By.xpath("//span[normalize-space()='" + amPm + "']");
        eleUtil.doClick(amPmOption);

        // Select Method of Communication
        entryForm.findElement(methodOfCommunicationDropdown);
        eleUtil.waitForElementToBeClickable(10, methodOfCommunicationDropdown);
        eleUtil.doClick(methodOfCommunicationDropdown);
        By methodOfCommunicationOption = By.xpath("//span[@class='mdc-list-item__primary-text' and contains(text(), '" + methodOfCommunication + "')]");
        eleUtil.doClick(methodOfCommunicationOption);

        entryForm.findElement(communicationDetailsInput);
        eleUtil.waitForElementToBeClickable(10, communicationDetailsInput);
        eleUtil.doSendKeys(communicationDetailsInput, communicationDetail);
        
        entryForm.findElement(whoCompletedInterviewInput);
        eleUtil.waitForElementToBeClickable(10, whoCompletedInterviewInput);
        eleUtil.doSendKeys(whoCompletedInterviewInput, whoCompletedInterview);
        
        entryForm.findElement(yoFieldInput);
        eleUtil.waitForElementToBeClickable(10, yoFieldInput);
        eleUtil.doSendKeys(yoFieldInput, yo);
       
        // Click Save button
        entryForm.findElement(saveButton);
        eleUtil.waitForElementVisible(saveButton, 10).click();
       // eleUtil.doClick(saveButton);

        // Handle success message
        eleUtil.waitForElementVisible(successMsgButton, 10);
        eleUtil.waitForElementVisible(successMsgButton, 10).click();
        //eleUtil.doClick(successMsgButton);

        // Ensure the page is ready for the next entry
        eleUtil.waitForElementVisible(addButton, 10);
    }
}
