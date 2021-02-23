package singletonDesignPattern;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest {

	@BeforeClass() //@BeforeMethod
	public void setUp(){
		TestBase.initalizeDriver();
	}
	
	@Test(priority = 1)
	public void enterFirstName(){
		TestBase.driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("David");
	}
	
	@Test(priority = 2)
	public void enterPhoneNumber() throws Exception{
		TestBase.driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("111-222-3333");
	}	
	
	@AfterClass() //@AfterMethod
	public void tearDown(){
		TestBase.quit();
	}
}
