package dcri.qa.proep.tests;

import org.testng.annotations.Test;

import dcri.qa.proep.base.BaseTest;

public class AddScheduleTest extends BaseTest {
	
	 @Test
	    public void addScheduleTest() throws InterruptedException {
		 addschedulepage.addScheduleEntries();
	    }

}
