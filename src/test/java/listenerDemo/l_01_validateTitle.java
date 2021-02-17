package listenerDemo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.baseTest;

@Listeners(listenerDemo.l_01_listenersTest.class) // ====This is how we use listener when we run individual class====
public class l_01_validateTitle extends baseTest {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initalizeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validateAppTitle() throws IOException {
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		System.out.println("Test completed");
		Assert.assertTrue(false);
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
