package dcri.qa.proep.tests;

import org.testng.annotations.Test;

import dcri.qa.proep.base.BaseTest;


public class UserPageTest  extends BaseTest {
	
	@Test
	public void  createUsertest() {
		
		userpage.createUser();
		
		
	}

}
