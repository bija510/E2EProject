package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class baseTest {
	/*******************************************************************************
	 * If driver is not static them Extend report and listener will Not work
	 * And it will throw the Null pointer Exception
	 ********************************************************************************/
	public static WebDriver driver;
	public Properties prop ;

	public WebDriver initalizeDriver() throws IOException {
		prop =new Properties();         
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String chromePath = prop.getProperty("url");

		System.out.println(chromePath);
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
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return driver;
	}

	public void getScreenshot(String result) throws IOException {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//Screenshot//" + result + Math.random()+".BT.png"));
		} catch (Exception e) {

		}
	}

}