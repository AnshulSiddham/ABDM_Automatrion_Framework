package Module_HBI;

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

public class LoginPage extends TestBase
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public boolean mohfwLogo() throws EncryptedDocumentException, IOException
	{
		WebElement mohfwLogo1                = driver.findElement(By.xpath(ReadExcel.readExcelFile(1, 1)));
		return mohfwLogo1.isDisplayed();
	}
	
	public boolean loginToHBIforHP() throws InterruptedException, IOException 
	{
		WebElement loginRegistrationBtn      = driver.findElement(By.xpath(ReadExcel.readExcelFile(2, 1)));
		loginRegistrationBtn.click();
		Thread.sleep(2000);
		WebElement healthcareProfessionalOpt = driver.findElement(By.xpath(ReadExcel.readExcelFile(3, 1)));
		healthcareProfessionalOpt.click();
		Thread.sleep(2000);
		WebElement loginBtn                  = driver.findElement(By.xpath(ReadExcel.readExcelFile(4, 1)));
		loginBtn.click();
		Thread.sleep(2000);
		WebElement hpidTextBox               = driver.findElement(By.xpath(ReadExcel.readExcelFile(5, 1)));
		hpidTextBox.clear();
		hpidTextBox.sendKeys(readPropertyFile("username"));	
		Thread.sleep(2000);
		WebElement submitBtn                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(6, 1)));
		submitBtn.click();
		Thread.sleep(2000);
		WebElement loginWithPasswordBtn      = driver.findElement(By.xpath(ReadExcel.readExcelFile(7, 1)));
		loginWithPasswordBtn.click();
		Thread.sleep(2000);
		WebElement passwordTextBox           = driver.findElement(By.xpath(ReadExcel.readExcelFile(8, 1)));
		passwordTextBox.sendKeys(readPropertyFile("password"));
		Thread.sleep(2000);
		WebElement loginBtn2                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(9, 1)));
		loginBtn2.click();
//		WebElement drName                    = driver.findElement(By.xpath(ReadExcel.readExcelFile(10, 1)));
		WebElement logoutBtn                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(11, 1)));
		
		Thread.sleep(2000);
		return logoutBtn.isDisplayed();    
	}
	
	public String loginToHBIforNodalOfficer() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebElement loginRegistrationBtn      = driver.findElement(By.xpath(ReadExcel.readExcelFile(2, 1)));
		loginRegistrationBtn.click();
		Thread.sleep(2000);
		WebElement nodalOfficerOpt           = driver.findElement(By.xpath(ReadExcel.readExcelFile(15, 1)));
		nodalOfficerOpt.click();
		Thread.sleep(2000);
		WebElement loginBtn1                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(4, 1)));
		loginBtn1.click();
		Thread.sleep(2000);
		WebElement emailIDTextbox            = driver.findElement(By.xpath(ReadExcel.readExcelFile(16, 1)));
		emailIDTextbox.clear();
		emailIDTextbox.sendKeys(readPropertyFile("Email_ID"));
		Thread.sleep(2000);
		WebElement passwordTextBox           = driver.findElement(By.xpath(ReadExcel.readExcelFile(17, 1)));
		passwordTextBox.clear();
		passwordTextBox.sendKeys(readPropertyFile("Password"));
		Thread.sleep(2000);
		WebElement loginBtn2                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(18, 1)));
		loginBtn2.click();
		Thread.sleep(2000);
		WebElement profileName               = driver.findElement(By.xpath(ReadExcel.readExcelFile(19, 1)));
		
		String userName = profileName.getText();
		System.out.println("USER NAME + " +userName);
		return userName;
		
	}
	public boolean azadiLogo() throws EncryptedDocumentException, IOException
	{
		WebElement azadiLogo                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(12, 1)));
		boolean value = azadiLogo.isDisplayed();
		return value;
	}
	
	public String mohfwLink() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebElement mohfwLink                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(13, 1)));
		js.executeScript("arguments[0].scrollIntoView();", mohfwLink);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", mohfwLink);
		Thread.sleep(2000);
		System.out.println("URL = " +driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public void NodalOfficer() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebElement loginRegistrationBtn      = driver.findElement(By.xpath(ReadExcel.readExcelFile(2, 1)));
		loginRegistrationBtn.click();
		Thread.sleep(2000);
		WebElement nodalOfficerOpt           = driver.findElement(By.xpath(ReadExcel.readExcelFile(15, 1)));
		nodalOfficerOpt.click();
		Thread.sleep(2000);
		WebElement loginBtn1                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(4, 1)));
		loginBtn1.click();
		Thread.sleep(2000);
		WebElement emailIDTextbox            = driver.findElement(By.xpath(ReadExcel.readExcelFile(16, 1)));
		emailIDTextbox.clear();
		emailIDTextbox.sendKeys(readPropertyFile("Email_ID"));
		Thread.sleep(2000);
		WebElement passwordTextBox           = driver.findElement(By.xpath(ReadExcel.readExcelFile(17, 1)));
		passwordTextBox.clear();
		passwordTextBox.sendKeys(readPropertyFile("Password"));
		Thread.sleep(2000);
		WebElement loginBtn2                 = driver.findElement(By.xpath(ReadExcel.readExcelFile(18, 1)));
		loginBtn2.click();
		Thread.sleep(2000);
	}
}
