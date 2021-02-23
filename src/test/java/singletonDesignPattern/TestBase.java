package singletonDesignPattern;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	/************************************************************************************************************
	 =========SINGLETON DESIGN PATTERN===========
	
	Pros:-Singletons are considered bad because they make unit testing and debugging difficult
	Cons:-only one object of the class & that’s it . this won’t allow you to create multiple object of same class.
	**************************************************************************************************************/
	
	public static WebDriver driver=null;
	
	public static void initalizeDriver(){
		if(driver==null) {
			String browserName = Constants.browserName;
		
			if (browserName.equalsIgnoreCase("CHROME")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browserName.equalsIgnoreCase("FIREFOX")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			else if (browserName.equalsIgnoreCase("EDGE")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
		 }
	}
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
	}
	public static void quit() {
		System.out.println("Quiting the Browser");
		driver.quit();
		driver=null;		
	}
}
