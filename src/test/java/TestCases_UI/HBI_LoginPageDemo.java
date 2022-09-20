package TestCases_UI;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import Pages.HBI_LoginPage;
import Utility.Screenshot;

public class HBI_LoginPageDemo extends TestBase
{
	HBI_LoginPage login;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void extentReport()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "10711204");
		extent.addSystemInfo("User Name", "Anshul");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("OS", "Windows");
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
	
	public static String getScreenshot(WebDriver driver, String name) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyddmmhhmmss").format(new Date());
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\10711204\\eclipse-workspace\\Automation_UI\\"
		           		+ "Screenshots_Failed\\"+name+".png");
		FileUtils.copyFile(source, dest);
//	    FileHandler.copy(source, dest); 
		return dest.getAbsolutePath();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		
		initialization();
		login = new HBI_LoginPage();
	}
	
	@Test
	public void verifyMOHFWLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.startTest("verifyMOHFWLogo");
		boolean value = login.mohfwLogo();
		System.out.println("Value is " +value);
		Assert.assertEquals(value, true);
	}
	@Test
	public void verifyLoginToHBITest() throws InterruptedException, IOException
	{
		test = extent.startTest("verifyLoginToHBITest");
		boolean value = login.loginToHBIforHP();
		Assert.assertEquals(value, true);
	}
	
	@AfterMethod
	public void exit(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "TEST CASE FAILED IS " +result.getName());
			test.log(LogStatus.FAIL, "TEST CASE ERROR IS " +result.getThrowable()); // to add error and exception to extent report
			
			String screeshotPath = HBI_LoginPageDemo.getScreenshot(driver, result.getName()); // to add name in extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screeshotPath)); // to add screesshot to extent report
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, "TEST CASE SKIPPED IS " +result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "TEST CASE PASSED IS " +result.getName());
		}
		
		extent.endTest(test); // ending the test and current test and prepare html report
		driver.quit();
	}
}
