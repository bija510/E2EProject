package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageTest {

	public WebDriver driver;

	public LoginPageTest(WebDriver driver) {
		this.driver = driver;
	}

	private By username = By.cssSelector("#user_email");
	private By password = By.cssSelector("#user_password");
	private By login = By.cssSelector("input[name='commit']");

	public WebElement getEmail() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
