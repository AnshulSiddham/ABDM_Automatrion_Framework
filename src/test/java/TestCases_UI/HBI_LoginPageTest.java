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
	
	@BeforeMethod
	public void setup() throws IOException
	{                                                                  
		initialization();
		login = new LoginPage();
	}
	
	@Test(enabled = true, priority = 1)
	public void verifyMOHFWLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.createTest("MOHFW Logo");
		boolean value = login.mohfwLogo();
		Assert.assertEquals(value, true);	
	}
	
	@Test(enabled = true, priority = 2)
	public void verifyAzadiLogo() throws EncryptedDocumentException, IOException
	{
		test = extent.createTest("Azadi Logo");
		boolean value = login.azadiLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test(enabled = true, priority = 3)
	public void verifymohfwLink() throws EncryptedDocumentException, IOException, InterruptedException
	{
        test = extent.createTest("MOHFW link at Footer");
		String expectedURL = "https://www.mohfw.gov.in/";
		String actualURL = login.mohfwLink();
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(enabled = true, priority = 4)
	public void verifyLoginToHBIforHP() throws InterruptedException, IOException
	{
        test = extent.createTest("Login to HBI with Healthcare Professional");
		boolean value = login.loginToHBIforHP();
		Assert.assertEquals(value, true);
	}
	
	@Test(enabled = true, priority = 5)
	public void verifyloginToHBIforNodalOfficer() throws EncryptedDocumentException, IOException, InterruptedException
	{
        test = extent.createTest("Login to HBI with Nodal Officer");
		String actualValue = login.loginToHBIforNodalOfficer();
		String  expectedValue = "Chandra DV";
		Assert.assertEquals(actualValue, expectedValue);
	}

}
