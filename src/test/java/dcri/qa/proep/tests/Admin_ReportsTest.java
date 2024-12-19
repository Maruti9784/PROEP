package dcri.qa.proep.tests;

import org.testng.annotations.Test;

import dcri.qa.proep.base.BaseTest;

public class Admin_ReportsTest extends BaseTest {
	
	//@BeforeClass
		//public void homepageSetup() {
			
			//homepage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		//}

	@Test
	public void testSelectSchedulesReport() {
		// Test Data: date to filter
		String date = "06/25/2024";

		// Select Schedules Report and filter by the provided date
		reportspage.selectSchedulesReport(date);

	}

	@Test
	public void testSelectUserSchedulesReport() {
		String startdate = "5";
		String enddate = "25";
		reportspage.selectUserSchedulesReport(startdate, enddate);
	}

}
