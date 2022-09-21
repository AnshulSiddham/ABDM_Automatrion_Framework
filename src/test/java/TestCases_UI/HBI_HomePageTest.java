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

import Base.TestBase;
import Module_HBI.HomePage;
import Module_HBI.LoginPage;

public class HBI_HomePageTest extends TestBase
{
	 LoginPage login;
     HomePage homePage;
	
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
	public void setup() throws IOException, EncryptedDocumentException, InterruptedException
	{
		initialization();
		login = new LoginPage();
		login.NodalOfficer();
		homePage = new HomePage();
	}
	
	@Test
	public void verifyProfile() throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = extent.startTest("Profile oF Nodal Officer");
		String expectedEmail = "Chandradv@gmail.com";
		String actualEmail   = homePage.profile();
		
		AssertJUnit.assertEquals(actualEmail, expectedEmail);
	}
	
	@AfterMethod
	public void exit(ITestResult result) throws IOException 
	{	
		afterMethod(result);
		driver.quit();
	}
	

}
