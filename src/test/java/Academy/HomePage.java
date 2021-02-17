package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initalizeDriver(); 
		Log.info("driver is instanciated");	
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		Log.info("Url open Successfully");
	
	LandingPage l = new LandingPage(driver);
		l.getLogin().click();
	
	LoginPage log =new LoginPage(driver);
		log.getEmail().sendKeys(Username);
		log.getPassword().sendKeys(Password);
		log.getLogin().click();
	
	Log.info("Text");
	}
	@AfterTest
    public void teardown() {		
		driver.close();
		driver=null;	 
    }
	
//	@AfterMethod
//	public void screenShot(ITestResult result) throws IOException {
//		if(ITestResult.FAILURE == result.getStatus()) {
//			getScreenshot(result.getName()); 
//		  }
//	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];    // whole set 1st row | =2 and in each set there is column -- =3
		//oth row  
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restricted user";
				
		//1st row
		data[1][0]="nonrestricteduser@qw.com";
		data[1][1]="45678";
		data[0][2]="Non restricted user";
		return data;
	}

	}
