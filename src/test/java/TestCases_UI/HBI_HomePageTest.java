package TestCases_UI;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Module_HBI.HomePage;
import Module_HBI.LoginPage;

public class HBI_HomePageTest extends TestBase
{
	 LoginPage login;
     HomePage homePage;
	
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
		String expectedEmail = "Chandradv@gmail.com";
		String actualEmail   = homePage.profile();
		Assert.assertEquals(actualEmail, expectedEmail);
	}

}
