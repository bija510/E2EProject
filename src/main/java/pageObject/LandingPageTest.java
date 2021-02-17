package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//import resources.base;

public class LandingPageTest {
	/*****************************************************************************************************************
    NOTE:- Hiding data implementation by declaring data or variable private and public method is called Encapsulation
	This is how we achieve Encapsulation in Selenium java framework
	*****************************************************************************************************************/
	public WebDriver driver;
	
	public LandingPageTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//=========Design Pattern:- 1============
	@FindBy(how = How.CSS, using = "a[href*='sign_in']") 
	private WebElement signin;

	//=========Design Pattern:- 2============
	@FindBy(how = How.CSS, using = "//h2[@class='_8est']") 
	private WebElement Title;
	
	//=========Design Pattern:- 3============
	@FindBy(css = ".nav.navbar-nav.navbar-right>li>a")
	private WebElement getNavigationbarbar;
	
	
	public WebElement getLogin(){
		return signin;
	}
	
	public WebElement getTitle(){
		return Title;
	}
	
	public WebElement getNavigationbarbar(){
		return getNavigationbarbar;
	}
	
}
