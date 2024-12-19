package dcri.qa.proep.pages;



import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dcri.qa.proep.constants.AppConstants;
import dcri.qa.proep.utils.ElementUtil;
import dcri.qa.proep.utils.JavaScriptUtil;

public class ReportsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;

	// Locators
	private By reportsTab = By.xpath("//div[contains(text(),'Reports')]");
	private By reportSelectionDropdown = By.id("mat-select-36");
	private By schedulesReportOption = By.xpath("//span[text()='Schedules Report']");
	private By datePicker = By.id("mat-input-2");
	private By click_on_date_window = By.xpath("//app-calendar-controls[@id='day-calendar-controls']");
	private By Click_PDF = By.cssSelector("#report-pdf-button");
	private By userSchedulesReportOption = By.xpath("//span[text()='User Schedules']");
	private By runReportButton = By.id("run-report-button");
	private By headerRow = By.xpath("//tr[@role='row' and contains(@class, 'mat-mdc-header-row')]");
	private By userDropdown = By.id("mat-select-38");
	private By userOption = By.xpath("//span[text()='Maruti Gollar']");
	private By calendarButton = By.xpath("//span[@class='mat-mdc-button-touch-target']");
	private By calendarTable = By.className("mat-calendar-table");
	 private By currentMonthYearLocator;
	 private By yearLocator = By.xpath("//span[contains(@class, 'mat-calendar-body-cell-content') and normalize-space(text())='2024']");
	 private By targetMonthLocator;
	 private By startDateLocator;
	 private By endDateLocator;
	

    private final String downloadFilepath = "C:\\Users\\mbg42\\Downloads";
    private final String pdfFileName = "DailySchedulesReport_svc_automation_qa_01.pdf";
    private final String startdate = "";
    private final String enddate = "";
    private final String targetMonth = "JUL";

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementUtil(driver);
		this.jsUtil = new JavaScriptUtil(driver);
	}

	public void selectSchedulesReport(String date) {

		eleUtil.waitForElementVisible(reportsTab, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();

		eleUtil.doClick(reportSelectionDropdown);

		eleUtil.waitForElementVisible(schedulesReportOption, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();

		WebElement dateInput = eleUtil.getElement(datePicker);
		jsUtil.clearValueUsingJS(dateInput);

		eleUtil.doSendKeys(datePicker, date);

		eleUtil.doSendKeys(datePicker, Keys.ENTER.name());

		try {
			Thread.sleep(AppConstants.DEFAULT_SHORTEST_TIME_OUT * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		eleUtil.waitForElementVisible(click_on_date_window, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();

		eleUtil.waitForTextInElementValue(datePicker, AppConstants.DEFAULT_MEDIUM_TIME_OUT, date);

		eleUtil.waitForElementVisible(Click_PDF, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		
		 try {
	            Thread.sleep(AppConstants.DEFAULT_SHORTEST_TIME_OUT * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Verify the PDF download
	        verifyAndDeletePDF(downloadFilepath, pdfFileName);
	    }

	public void selectUserSchedulesReport(String startdate,String enddate) {
		
		eleUtil.waitForElementVisible(reportsTab, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();

		eleUtil.doClick(reportSelectionDropdown);

		eleUtil.waitForElementVisible(userSchedulesReportOption, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		
		 eleUtil.doClick(userDropdown);
	        eleUtil.doClick(userOption);
	        eleUtil.doClick(calendarButton);
	        eleUtil.waitForElementVisible(calendarTable, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
	        
	        // Set report date range
	        LocalDate currentDate = LocalDate.now();
	        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMM yyyy");
	        String cuurentMonthYear = currentDate.getMonth().toString().substring(0, 3).toUpperCase(); // Current month in short form e.g. "OCT"
	        currentMonthYearLocator = By.xpath("//span[contains(text(),'" + cuurentMonthYear + "')]" );
	        targetMonthLocator = By.xpath("//span[normalize-space()='" + targetMonth + "']");
	        startDateLocator = By.xpath("//span[normalize-space()='" + startdate  + "']");
	        endDateLocator = By.xpath("//span[normalize-space()='" + enddate  + "']");

	        eleUtil.doClick(currentMonthYearLocator);
	        eleUtil.doClick(yearLocator);
	        eleUtil.doClick(targetMonthLocator);
	        eleUtil.doClick(startDateLocator);
	        eleUtil.doClick(endDateLocator);
	        
	        eleUtil.waitForElementVisible(runReportButton, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
	        
	        // Validate report columns
	        List<String> expectedColumnNames = Arrays.asList(
	                "Name", "Project", "Day", "Date", "Start Time", "End Time", "Hours", "Comments");
	        WebElement headerRowElement = eleUtil.getElement(headerRow);
	        List<WebElement> columnHeaders = headerRowElement.findElements(By.tagName("th"));
	        List<String> actualColumnNames = new ArrayList<>();

	        for (WebElement header : columnHeaders) {
	            actualColumnNames.add(header.getText().trim());
	        }

	        if (actualColumnNames.equals(expectedColumnNames)) {
	            System.out.println("Validation Passed: All expected columns are present and in the correct order.");
	        } else {
	            System.out.println("Validation Failed: Column names do not match.");
	            System.out.println("Expected: " + expectedColumnNames);
	            System.out.println("Actual: " + actualColumnNames);
	        }


		
	}
	
	    private void verifyAndDeletePDF(String downloadFilepath, String pdfFileName) {
	        File folder = new File(downloadFilepath);
	        File[] listOfFiles = folder.listFiles();
	        boolean pdfDownloaded = false;

	        for (File file : listOfFiles) {
	            if (file.isFile() && file.getName().equals(pdfFileName)) {
	                pdfDownloaded = true;
	                System.out.println("PDF file downloaded: " + file.getName());
	                // Delete the PDF
	                if (file.delete()) {
	                    System.out.println("PDF file deleted successfully.");
	                } else {
	                    System.out.println("Failed to delete the PDF file.");
	                }
	                break;
	            }
	        }

	        if (!pdfDownloaded) {
	            System.out.println("Test Failed: PDF not downloaded.");
	        }
		

	}
}
