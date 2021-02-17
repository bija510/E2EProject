package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.LandingPageTest;
import pageObject.LoginPageTest;
import resources.baseTest;


public class HomePageTest extends baseTest {
	
	
	public static Logger Log = LogManager.getLogger(baseTest.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initalizeDriver();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws Exception {
		driver.get(prop.getProperty("url"));
		LandingPageTest land = new LandingPageTest(driver);
		land.getLogin().click();

		LoginPageTest log = new LoginPageTest(driver);
		log.getEmail().sendKeys(Username);
		log.getPassword().sendKeys(Password);
		log.getLogin().click();
		Log.info("Text");
		
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3]; // [2]==> row , [3]==>Column  || we are predefining Size of Row & Column
		// oth row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted user";

		// 1st row
		data[1][0] = "nonrestricteduser@qw.com";
		data[1][1] = "45678";
		data[1][2] = "Non restricted user";
		return data;
	}

}
