package dcri.qa.proep.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dcri.qa.proep.base.BaseTest;

public class LoginPageTest extends BaseTest{

	@Test
	public void loginTest() {
		homepage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertTrue(homepage.isHomePageLinkExist());
		
		
	}
}
