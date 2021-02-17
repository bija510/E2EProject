package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObject.LandingPageTest;
import resources.baseTest;

public class validateTitleTest extends baseTest {
	public static Logger Log = LogManager.getLogger(baseTest.class.getName());

	@BeforeTest
	public void initialize() throws IOException 
	{
		driver = initalizeDriver(); 
		Log.info("Driver is initalized");
		
		driver.get(prop.getProperty("url"));
		Log.info("Navigate to homepage");
	}
	
	
	@Test
	public void validateAppTitle() throws IOException {
		LandingPageTest l = new LandingPageTest(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		Log.info("Succesfully validated text message");
		System.out.println("Test completed");
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
