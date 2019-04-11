package lesson1;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tutorial {
	public WebDriver driver;
  @Test
  public <ChromeProfiles> void main() throws InterruptedException{
	  driver.findElement(By.xpath("//*[@class='shopee-popup__close-btn']")).click();
	  driver.findElement(By.xpath("//*[@id='main']")).click();
	  
	  driver.findElement(By.xpath("//*[@class='shopee-searchbar-input__input']")).sendKeys("Gang Tay Tap ta");
	  driver.findElement(By.xpath("//*[@class='shopee-svg-icon ']")).click();
	  driver.findElement(By.xpath("//*[@text()='120.000']")).click();

//	  
  }
  @BeforeTest
  public void beforeTest() {
	  ChromeOptions ops = new ChromeOptions();
      ops.addArguments("--disable-notifications");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\chromedriver_7.2\\chromedriver.exe");
	  driver = new ChromeDriver(ops);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://fb.com");
	  //driver.manage().window().maximize();
	  }
  @AfterTest
  public void afterTest() {
	  System.out.println(" LogOut Successfully, now it is the time to Log Off buddy.");
  }

}
