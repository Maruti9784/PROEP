package dcri.qa.proep.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dcri.qa.proep.base.BaseTest;
import dcri.qa.proep.constants.AppConstants;

public class HomePageTest extends BaseTest {
	
	//@BeforeClass
	//public void homepageSetup() {
		
		//homepage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	//}
	
	@Test
	public void alltabsValueTest() {

        List<String> actualHomePageHeadersList = homepage.getHomePageHeadersList();
		System.out.println("Actual Home Page Headers List: " + actualHomePageHeadersList);
		System.out.println("Expected Home Page Headers List:" + AppConstants.EXPECTED_HOME_PAGE_HEADERS_LIST);
		Assert.assertEquals(actualHomePageHeadersList, AppConstants.EXPECTED_HOME_PAGE_HEADERS_LIST);
	}
	
	 

}
