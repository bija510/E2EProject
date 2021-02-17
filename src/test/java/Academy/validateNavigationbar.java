package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.base;

public class validateNavigationbar extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver = initalizeDriver(); 
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateAppNavBar() throws IOException {
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationbarbar().isDisplayed());
		Log.info("Navigation bar is displayd");
	
	
	}
	@AfterTest
    public void teardown() 
	{
		driver.close();
		driver=null; 
    }
	
//	@AfterMethod
//	public void screenShot(ITestResult result) throws IOException {
//		if(ITestResult.FAILURE == result.getStatus()) {
//			getScreenshot(result.getName()); 
//		  }
//		
//	   }
	  	
	}

	
