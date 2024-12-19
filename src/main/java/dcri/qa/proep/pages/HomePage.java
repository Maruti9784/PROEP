package dcri.qa.proep.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dcri.qa.proep.constants.AppConstants;
import dcri.qa.proep.utils.ElementUtil;

public class HomePage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By homePagelink = By.xpath("//div[contains(text(),'Home')]");
	private By alltabs = By.xpath("//div[@class='nav-item-text']");
	private By log_out = (By.xpath("//div[@id='logout-button']//a//*[name()='svg']"));
	
	// page const....
		public HomePage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}

		public boolean isHomePageLinkExist() {
			return eleUtil.waitForElementVisible(homePagelink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
		}
		
		public List<String> getHomePageHeadersList() {
			List<WebElement> alltabsList = eleUtil.waitForElementsVisible(alltabs, AppConstants.DEFAULT_MEDIUM_TIME_OUT);		
			List<String> alltabsValList = new ArrayList<String>();
			for (WebElement e : alltabsList) {
				String text = e.getText();
				alltabsValList.add(text);
			}
			return alltabsValList;
		}
		
		 public void logout() {
		        eleUtil.waitForElementVisible(log_out, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		        driver.quit();
		    }
		

}
