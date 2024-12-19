package dcri.qa.proep.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import dcri.qa.proep.constants.AppConstants;
import dcri.qa.proep.utils.ElementUtil;
import dcri.qa.proep.utils.TOTPGenerator;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// private By locators

	private By loginButton = By.xpath("//button[@id='login-btn']");
	private By duoLoginButton = By.id("idp_248482781_button");
	private By netIdButton = By.xpath("//button[@id='expand-netid']");
	private By usernameField = By.id("j_username");
	private By passwordField = By.id("j_password");
	private By duoPasscodeInput = By.id("duoPasscodeInput");
	private By submitButton = By.xpath("//button[@id='Submit']");

	// page const....
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// page actions/methods:
	public HomePage doLogin(String un, String pwd) {
		System.out.println("Proep login creds are : " + un + ":" + pwd);
		eleUtil.doClick(loginButton);
		eleUtil.doClick(duoLoginButton);
		eleUtil.doClick(netIdButton);
		eleUtil.waitForElementVisible(usernameField, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(passwordField, pwd);

		try {
			Thread.sleep(AppConstants.DEFAULT_SHORTEST_TIME_OUT * 1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String secret = "KK4F2iS5DpnzDjADFUfgdZ9PdqxuSm3HRmBIvskf5Ln2uCHyh8kDXcwYf5ZqodXGuPEUKMVrJuV4fUMCbk6uZiCtXkYEb4xktqgS"; 

		long currentTime = System.currentTimeMillis() / 1000L;
		String totp = TOTPGenerator.generateTOTP(secret, currentTime);

		eleUtil.doClick(duoPasscodeInput);
		eleUtil.doSendKeys(duoPasscodeInput, totp);

		try {
			Thread.sleep(AppConstants.DEFAULT_SHORTEST_TIME_OUT * 1000); // Wait for the specified time in seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		eleUtil.doClick(submitButton);

		return new HomePage(driver);
	}
}
