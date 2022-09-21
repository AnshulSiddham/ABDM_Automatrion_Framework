package TestCases_UI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import Module_HBI.LoginPage;
import Utility.Screenshot;

public class HBI_LoginPageTest extends TestBase
{
	LoginPage login;
	
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
		login = new LoginPage();
	}
	
	@Test(enabled = true, priority = 1)
	public void verifyMOHFWLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.startTest("verifyMOHFWLogo");
		boolean value = login.mohfwLogo();
		AssertJUnit.assertEquals(value, true);
	}
	
	@Test(enabled = true, priority = 2)
	public void verifyAzadiLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.startTest("verifyHBILogo");
		boolean value = login.azadiLogo();
		AssertJUnit.assertEquals(value, true);
	}
	
	@Test(enabled = false, priority = 3)
	public void verifymohfwLink() throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = extent.startTest("verifymohfwLink");
		String expectedURL = "https://www.mohfw.gov.in/";
		String actualURL = login.mohfwLink();
		AssertJUnit.assertEquals(actualURL, expectedURL);
	}
	
	@Test(enabled = false, priority = 4)
	public void verifyLoginToHBIforHP() throws InterruptedException, IOException
	{
		test = extent.startTest("verifyLoginToHBIforHP");
		boolean value = login.loginToHBIforHP();
		AssertJUnit.assertEquals(value, true);
	}
	
	@Test(enabled = true, priority = 5)
	public void verifyloginToHBIforNodalOfficer() throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = extent.startTest("verifyloginToHBIforNodalOfficer");
		String actualValue = login.loginToHBIforNodalOfficer();
		String  expectedValue = "Chandra DV";
		AssertJUnit.assertEquals(actualValue, expectedValue);
	}
	
	
	@AfterMethod
	public void exit(ITestResult result) throws IOException 
	{	
		afterMethod(result);
		driver.quit();
	}

}
