package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class validateTitle extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());

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
	
	//one is inheritance
	//creating object to that class and invoke method of it 
	
	LandingPage l = new LandingPage(driver);
	Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
	Log.info("Succesfully validated text message");
	System.out.println("Test completed");
	Assert.assertTrue(false);
	}

	@AfterTest
     public void teardown() 
	{
		driver.close();
		driver=null;
    	 
     }
	}






