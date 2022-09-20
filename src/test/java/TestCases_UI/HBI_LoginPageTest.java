package TestCases_UI;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class HBI_LoginPageTest extends TestBase
{
	HBI_LoginPage login;
	
	@BeforeTest
	public void extentReport()
	{
		beforeTest();
	}
	
	@AfterTest
	public void endReport()
	{
		afterTest();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new HBI_LoginPage();
	}
	
	@Test(priority = 1)
	public void verifyMOHFWLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.startTest("verifyMOHFWLogo");
		boolean value = login.mohfwLogo();
		System.out.println("Value is " +value);
		Assert.assertEquals(value, true);
	}
	@Test(priority = 2)
	public void verifyLoginToHBITest() throws InterruptedException, IOException
	{
		test = extent.startTest("verifyLoginToHBITest");
		boolean value = login.loginToHBIforHP();
		Assert.assertEquals(value, true);
	}
	
	@AfterMethod
	public void exit(ITestResult result) throws IOException 
	{	
		afterMethod(result);
		driver.quit();
	}

}
