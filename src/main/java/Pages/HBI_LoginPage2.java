package Pages;

import java.io.IOException;
import java.net.SecureCacheResponse;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadExcel;

public class HBI_LoginPage2 extends TestBase
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public boolean mohfwLogo() throws EncryptedDocumentException, IOException
	{
		WebElement mohfwLogo1                = driver.findElement(By.xpath(ReadExcel.readExcelFile(1, 1)));
		return mohfwLogo1.isDisplayed();
	}
	
	public boolean loginToHBIforHP() throws InterruptedException, IOException 
	{
		WebElement loginRegistrationBtn      = driver.findElement(By.xpath(ReadExcel.readExcelFile(2, 2)));
		WebElement healthcareProfessionalOpt = driver.findElement(By.xpath(ReadExcel.readExcelFile(3, 1)));
		WebElement loginBtn                  = driver.findElement(By.xpath(ReadExcel.readExcelFile(4, 1)));
		WebElement hpidTextBox               = driver.findElement(By.xpath(ReadExcel.readExcelFile(5, 1)));
		WebElement submitBtn                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(6, 1)));
		WebElement loginWithPasswordBtn      = driver.findElement(By.xpath(ReadExcel.readExcelFile(7, 1)));
		WebElement passwordTextBox           = driver.findElement(By.xpath(ReadExcel.readExcelFile(8, 1)));
		WebElement loginBtn2                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(9, 1)));
		WebElement drName                    = driver.findElement(By.xpath(ReadExcel.readExcelFile(10, 1)));
		WebElement logoutBtn                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(11, 1)));
		
		
		loginRegistrationBtn.click();
		Thread.sleep(2000);
		healthcareProfessionalOpt.click();
		Thread.sleep(2000);
		loginBtn.click();
		Thread.sleep(3000);
		hpidTextBox.clear();
		hpidTextBox.sendKeys(readPropertyFile("username"));	
		Thread.sleep(2000);
		try
		{
		submitBtn.click();
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
			submitBtn.click();
		}
		loginWithPasswordBtn.click();
		Thread.sleep(2000);
		passwordTextBox.sendKeys(readPropertyFile("password"));
		Thread.sleep(2000);
		loginBtn2.click();

		Thread.sleep(2000);
		return logoutBtn.isDisplayed();    
	}
	public void loginToHBIforNodalOfficer() throws EncryptedDocumentException, IOException, InterruptedException
	{
		System.out.println("THIS IS LOGIN CHECK -----------------------------------------");
		WebElement loginRegistrationBtn      = driver.findElement(By.xpath(ReadExcel.readExcelFile(2, 2)));
		System.out.println("THIS IS LOGIN CHECK 2 -----------------------------------------");
//		WebElement nodalOfficerOpt           = driver.findElement(By.xpath(ReadExcel.readExcelFile(15, 1)));
//		WebElement loginBtn1                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(4, 1)));
//		WebElement emailIDTextbox            = driver.findElement(By.id(ReadExcel.readExcelFile(16, 2)));
//		WebElement passwordTextBox           = driver.findElement(By.xpath(ReadExcel.readExcelFile(17, 1)));
		System.out.println("THIS IS LOGIN CHECK 3-----------------------------------------");
//		WebElement loginBtn2                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(18, 1)));
//		WebElement profileName               = driver.findElement(By.xpath(ReadExcel.readExcelFile(19, 1)));
		
		System.out.println("THIS IS LOGIN XPATH CHECK -----------------------------------------");
		loginRegistrationBtn.click();
		Thread.sleep(2000);
		System.out.println("THIS IS LOGIN click CHECK -----------------------------------------");
//		nodalOfficerOpt.click();
//		Thread.sleep(2000);
//		loginBtn1.click();
//		Thread.sleep(2000);
//		emailIDTextbox.clear();
//		emailIDTextbox.sendKeys(readPropertyFile("Email ID"));
//		passwordTextBox.clear();
//		passwordTextBox.sendKeys(readPropertyFile("Password"));
//		Thread.sleep(2000);
//		loginBtn2.click();
		
//		String userName = profileName.getText();
//		System.out.println("USER NAME + " +userName);
//		return userName;
		
	}
	public boolean azadiLogo() throws EncryptedDocumentException, IOException
	{
		WebElement azadiLogo = driver.findElement(By.xpath(ReadExcel.readExcelFile(13, 1)));
		boolean value = azadiLogo.isDisplayed();
		return value;
	}
	
	public String mohfwLink() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebElement mohfwLink = driver.findElement(By.xpath(ReadExcel.readExcelFile(14, 1)));
		js.executeScript("arguments[0].scrollIntoView();", mohfwLink);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", mohfwLink);
		Thread.sleep(2000);
		System.out.println("URL = " +driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
}

