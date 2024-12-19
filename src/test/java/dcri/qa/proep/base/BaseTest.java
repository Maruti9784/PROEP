package dcri.qa.proep.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import dcri.qa.proep.factory.DriverFactory;
import dcri.qa.proep.pages.AddSchedulePage;
import dcri.qa.proep.pages.CommHubPage;
import dcri.qa.proep.pages.HomePage;
import dcri.qa.proep.pages.LoginPage;
import dcri.qa.proep.pages.ReportsPage;
import dcri.qa.proep.pages.UserPage;
import dcri.qa.proep.tests.LoginPageTest;

public class BaseTest {

    DriverFactory df;
    WebDriver driver;

    protected LoginPage loginPage;
    protected HomePage homepage;
    protected ReportsPage reportspage;
    protected AddSchedulePage addschedulepage;
    protected CommHubPage commhubpage;
    protected UserPage userpage;
    protected Properties prop;

    @BeforeMethod
    public void setup() {
        df = new DriverFactory();
        prop = df.initProp();
        driver = df.initDriver(prop);
        loginPage = new LoginPage(driver);
        reportspage = new ReportsPage(driver);
        addschedulepage = new AddSchedulePage(driver);
        commhubpage = new CommHubPage(driver);
        userpage = new UserPage(driver);
       // homepage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        // Only perform login if not testing login functionality itself
        if (!(this instanceof LoginPageTest)) {
            homepage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
