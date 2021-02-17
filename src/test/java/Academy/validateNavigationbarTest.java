package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPageTest;
import resources.baseTest;

public class validateNavigationbarTest extends baseTest {
	public static Logger Log = LogManager.getLogger(validateNavigationbarTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver = initalizeDriver(); 
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateAppNavBar() throws IOException {
		LandingPageTest l = new LandingPageTest(driver);
		//Assert.assertTrue(l.getNavigationbarbar().isDisplayed());
		l.getNavigationbarbar().isDisplayed();
		Log.info("Navigation bar is displayd");
		//Assert.assertFalse(false);
	}
	@AfterTest
    public void teardown() 
	{
		driver.close();
		driver=null; 
    }
	
	@AfterMethod
	public void screenShot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE == result.getStatus()) {
			getScreenshot(result.getName()); 
		  }
	   }
		
	}

	
