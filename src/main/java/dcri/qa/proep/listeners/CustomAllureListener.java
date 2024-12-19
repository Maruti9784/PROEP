package dcri.qa.proep.listeners;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;
import dcri.qa.proep.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CustomAllureListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        captureScreenshot("Screenshot of Passed Test");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot("Screenshot of Failed Test");
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] captureScreenshot(String screenshotName) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }

    // Implement other methods from ITestListener if needed
}
