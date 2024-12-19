/*
 * package dcri.qa.proep.listeners;
 * 
 * import io.qameta.allure.Attachment; import org.openqa.selenium.OutputType;
 * import org.openqa.selenium.TakesScreenshot; import
 * org.openqa.selenium.WebDriver; import org.testng.ITestContext; import
 * org.testng.ITestListener; import org.testng.ITestResult; import
 * dcri.qa.proep.factory.DriverFactory;
 * 
 * public class TestAllureListener implements ITestListener {
 * 
 * private static String getTestMethodName(ITestResult iTestResult) { return
 * iTestResult.getMethod().getConstructorOrMethod().getName(); }
 * 
 * // Screenshot for Allure
 * 
 * @Attachment(value = "Page screenshot", type = "image/png") public byte[]
 * saveScreenshotPNG(WebDriver driver) { return ((TakesScreenshot)
 * driver).getScreenshotAs(OutputType.BYTES); }
 * 
 * // Text log for Allure
 * 
 * @Attachment(value = "{0}", type = "text/plain") public static String
 * saveTextLog(String message) { return message; }
 * 
 * @Override public void onStart(ITestContext iTestContext) {
 * System.out.println("Starting tests in suite: " + iTestContext.getName()); }
 * 
 * @Override public void onFinish(ITestContext iTestContext) {
 * System.out.println("Finished tests in suite: " + iTestContext.getName()); }
 * 
 * @Override public void onTestStart(ITestResult iTestResult) {
 * System.out.println("Starting test method: " +
 * getTestMethodName(iTestResult)); }
 * 
 * @Override public void onTestSuccess(ITestResult iTestResult) {
 * System.out.println("Test method succeeded: " +
 * getTestMethodName(iTestResult)); }
 * 
 * @Override public void onTestFailure(ITestResult iTestResult) {
 * System.out.println("Test method failed: " + getTestMethodName(iTestResult));
 * 
 * WebDriver driver = DriverFactory.getDriver(); if (driver != null) {
 * System.out.println("Capturing screenshot for failed test: " +
 * getTestMethodName(iTestResult)); saveScreenshotPNG(driver); } else {
 * System.out.
 * println("Driver is null, unable to capture screenshot for failed test: " +
 * getTestMethodName(iTestResult)); }
 * 
 * // Log the failure to Allure saveTextLog(getTestMethodName(iTestResult) +
 * " failed and screenshot taken!"); }
 * 
 * @Override public void onTestSkipped(ITestResult iTestResult) {
 * System.out.println("Test method skipped: " + getTestMethodName(iTestResult));
 * }
 * 
 * @Override public void onTestFailedButWithinSuccessPercentage(ITestResult
 * iTestResult) {
 * System.out.println("Test failed but is within success percentage: " +
 * getTestMethodName(iTestResult)); } }
 */