package TestCases_UI;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
	
	@BeforeSuite
	public void extentReport()
	{
		beforeSuit();
	}
	
	@AfterSuite
	public void endReport()
	{
		afterSuit();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test(enabled = true, priority = 2)
	public void verifyMOHFWLogo() throws EncryptedDocumentException, IOException
	{
	    test = extent.startTest("verifyMOHFWLogo");
		boolean value = login.mohfwLogo();
		Assert.assertEquals(value, false);
	}
	
	@Test(enabled = true, priority = 1)
	public void verifyAzadiLogo() throws EncryptedDocumentException, IOException
	{
    	test = extent.startTest("verifyAzadiLogo");
		boolean value = login.azadiLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test(enabled = false, priority = 3)
	public void verifymohfwLink() throws EncryptedDocumentException, IOException, InterruptedException
	{
        test = extent.startTest("verifymohfwLink");
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
	
	@Test(enabled = false, priority = 5)
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
