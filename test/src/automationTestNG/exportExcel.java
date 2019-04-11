package automationTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;


public class exportExcel {

private static WebDriver driver;
@DataProvider(name = "Authentication")

public static Object[][] credentials() {

    // The number of times data is repeated, test will be executed the same no. of times

    // Here it will execute two times

    return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
}

//Here we are calling the Data Provider object with its Name

@Test(dataProvider = "Authentication")

public void test(String sUsername, String sPassword) {

	FirefoxOptions options = new FirefoxOptions();
	options.setProfile(new FirefoxProfile());
	options.addPreference("dom.webnotifications.enabled", false);
	driver = new FirefoxDriver(options);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get("http://www.fb.com");
driver.findElement(By.xpath(".//*[@id=\"email\"]")).click();
driver.findElement(By.xpath(".//*[@id=\"email\"]")).sendKeys("0935550601");
driver.findElement(By.xpath(".//*[@id=\"pass\"]")).click();
driver.findElement(By.xpath(".//*[@id=\"pass\"]")).sendKeys("zFounders97@!z");
driver.findElement(By.xpath(".//*[@id=\"u_0_2\" or @id=\"u_0_3\" or @id=\"u_0_8\"]")).click();
driver.findElement(By.id("userNavigationLabel")).click();
driver.findElement(By.xpath("/html/body/div[23]/div/div/div/div/div[1]/div/div/ul/li[16]/a/span/span")).click();

driver.quit();

}

}