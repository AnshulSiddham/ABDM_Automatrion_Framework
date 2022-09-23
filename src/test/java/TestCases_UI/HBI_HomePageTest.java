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

import Base.TestBase;
import Module_HBI.HomePage;
import Module_HBI.LoginPage;

public class HBI_HomePageTest extends TestBase
{
	 LoginPage login;
     HomePage homePage;
	
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
	
	@BeforeMethod
	public void setup() throws IOException, EncryptedDocumentException, InterruptedException
	{
		initialization();
		login = new LoginPage();
		login.loginNodalOfficer();
		homePage = new HomePage();
	}
	
	@Test(enabled = true)
	public void verifyProfile() throws EncryptedDocumentException, IOException, InterruptedException
	{
		test = extent.createTest("Profile oF Nodal Officer");
		
		
	//	test = extent.startTest("Profile oF Nodal Officer");
		String expectedEmail = "Chandradv@gmail.com";
		String actualEmail   = homePage.profile();
		Assert.assertEquals(actualEmail, expectedEmail);
	}
	
//	@AfterMethod
//	public void exit(ITestResult result) throws IOException 
//	{	
//		getResult(result);
////	afterMethod(result);
//		driver.quit();
//	}
	

}
