package practiceTestCases;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.DataProvider;

import exportTest.testExportfile;

public class DataProviderWithExcel_002 {

private String sTestCaseName;

private int iTestCaseRow;

WebDriver driver;
@BeforeMethod

public void beforeMethod() throws Exception {

	FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	  driver.get("http://www.fb.com"); 
}

@Test(dataProvider = "Authentication")

public void f(String sUserName, String sPassword) {

	WebElement emailClick = driver.findElement(By.xpath(".//*[@id=\"email\"]"));
	  emailClick.click();
	  emailClick.sendKeys(sUserName);
	  //Password
	  WebElement passwordClick = driver.findElement(By.xpath(".//*[@id=\"pass\"]"));
	  passwordClick.click();
	  passwordClick.sendKeys(sPassword);
	  //Login button
	  driver.findElement(By.xpath(".//*[@id=\"u_0_2\" or @id=\"u_0_3\" or @id=\"u_0_8\"]")).click();
	  //Check login
	 


	}

@AfterMethod

public void afterMethod() {

   driver.close();
}

@DataProvider

public Object[][] Authentication() throws Exception{

    // Setting up the Test Data Excel file

	testExportfile.getTableArray("C:\\Users\\Administrator\\eclipse-workspace\\test\\src\\testDatas\\TestData.xlsx","Sheet1", 0);

 	sTestCaseName = this.toString();

  	// From above method we get long test case name including package and class name etc.

  	// The below method will refine your test case name, exactly the name use have used

  	sTestCaseName = testExportfile.getTestCaseName(this.toString());

    // Fetching the Test Case row number from the Test Data Sheet

    // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet

 	iTestCaseRow = testExportfile.getRowContains(sTestCaseName,0);

    Object[][] testObjArray = testExportfile.getTableArray("C:\\Users\\Administrator\\eclipse-workspace\\test\\src\\testDatas\\TestData.xlsx","Sheet1",iTestCaseRow);

    	return (testObjArray);

	}
}