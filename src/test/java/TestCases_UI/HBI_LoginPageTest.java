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
import Pages.HBI_LoginPage2;
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
	
	@Test(enabled = false, priority = 1)
	public void verifyMOHFWLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.startTest("verifyMOHFWLogo");
		boolean value = login.mohfwLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test(enabled = true, priority = 2)
	public void verifyAzadiLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.startTest("verifyHBILogo");
		boolean value = login.azadiLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test(enabled = false, priority = 3)
	public void verifymohfwLink() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String expectedURL = "https://www.mohfw.gov.in/";
		String actualURL = login.mohfwLink();
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(enabled = false, priority = 4)
	public void verifyLoginToHBIforHP() throws InterruptedException, IOException
	{
		test = extent.startTest("verifyLoginToHBIforHP");
		boolean value = login.loginToHBIforHP();
		Assert.assertEquals(value, true);
	}
	
	@Test(enabled = true, priority = 5)
	public void verifyloginToHBIforNodalOfficer() throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = extent.startTest("verifyloginToHBIforNodalOfficer");
		String actualValue = login.loginToHBIforNodalOfficer();
		String  expectedValue = "Chandra DV";
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	
	@AfterMethod
	public void exit(ITestResult result) throws IOException 
	{	
		afterMethod(result);
		driver.quit();
	}

}
