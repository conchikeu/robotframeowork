package automationTestNG;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class NewTest {
	public WebDriver driver;
	
	@DataProvider
	  public static Object[][] credentials() {

		    return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
		}
	
	
	@Parameters({ "sUsername", "sPassword" })
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword) {
  // Argument passed will be used here as String Variable

	  WebElement emailClick = driver.findElement(By.xpath(".//*[@id=\"email\"]"));
	  emailClick.click();
	  emailClick.sendKeys(sUsername);
	  //Password
	  WebElement passwordClick = driver.findElement(By.xpath(".//*[@id=\"pass\"]"));
	  passwordClick.click();
	  passwordClick.sendKeys(sPassword);
	  //Login button
	  driver.findElement(By.xpath(".//*[@id=\"u_0_2\" or @id=\"u_0_3\" or @id=\"u_0_8\"]")).click();
	  String checkTitle = driver.getTitle();
	  String checkTitleLogin = "Facebook";
	  Assert.assertEquals(checkTitle, checkTitleLogin);
	  System.out.println("Login Succes!");

	  driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
	FirefoxOptions options = new FirefoxOptions();
	options.setProfile(new FirefoxProfile());
	options.addPreference("dom.webnotifications.enabled", false);
	driver = new FirefoxDriver(options);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("http://www.fb.com");
	}
}
