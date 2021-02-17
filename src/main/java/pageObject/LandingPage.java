package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	//1. Initialization
	public LandingPage(WebDriver driver) {
		this.driver =driver;
	}
	
	//2. Deceleration
	private By signin = By.xpath("//span[contains(text(),'Login')]");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right'");
	
	//3. Utilization
	public WebElement getLogin(){
		return driver.findElement(signin);
	}
	
	public WebElement getTitle(){
		return driver.findElement(title);
	}
	
	public WebElement getNavigationbarbar(){
		return driver.findElement(navbar);
	}
	
}
