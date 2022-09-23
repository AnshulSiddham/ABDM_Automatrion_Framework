package TestCases_UI;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Base.TestBase;
import ExtentReport_Listener.Listener;
import Module_HBI.LoginPage;

public class HBI_LoginPageTest extends TestBase
{
	LoginPage login;
	
//	@BeforeSuite
//	public void extentReport()
//	{
//		beforeSuit();
//	}
//	
//	@AfterSuite
//	public void endReport()
//	{
//		afterSuit();
//	}
//	
	@BeforeMethod
	public void setup() throws IOException
	{                                                                  
		initialization();
		login = new LoginPage();
	}
	
	@Test(enabled = true, priority = 2)
	public void verifyMOHFWLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.createTest("MOHFW Logo");
		
//	    test = extent.startTest("verify MOHFW Logo");
		boolean value = login.mohfwLogo();
		Assert.assertEquals(value, true);
		
		
	}
	
	@Test(enabled = true, priority = 1)
	public void verifyAzadiLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.createTest("Azadi Logo");
		
//		test = extent.startTest("verify Azadi Logo");
		boolean value = login.azadiLogo();
		Assert.assertEquals(value, false);
	}
	
	@Test(enabled = false, priority = 3)
	public void verifymohfwLink() throws EncryptedDocumentException, IOException, InterruptedException
	{
 //     test = extent.startTest("verifymohfwLink");
		String expectedURL = "https://www.mohfw.gov.in/";
		String actualURL = login.mohfwLink();
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(enabled = false, priority = 4)
	public void verifyLoginToHBIforHP() throws InterruptedException, IOException
	{
//      test = extent.startTest("verifyLoginToHBIforHP");
		boolean value = login.loginToHBIforHP();
		Assert.assertEquals(value, true);
	}
	
	@Test(enabled = false, priority = 5)
	public void verifyloginToHBIforNodalOfficer() throws EncryptedDocumentException, IOException, InterruptedException
	{
//      test = extent.startTest("verifyloginToHBIforNodalOfficer");
		String actualValue = login.loginToHBIforNodalOfficer();
		String  expectedValue = "Chandra DV";
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	@AfterMethod
	public void exit(ITestResult result) throws IOException 
	{	
		getResult(result);
//		afterMethod(result);
		driver.quit();
	}

}
