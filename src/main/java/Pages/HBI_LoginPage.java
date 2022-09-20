package Pages;

import java.io.IOException;
import java.net.SecureCacheResponse;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadExcel;

public class HBI_LoginPage extends TestBase
{
	public boolean mohfwLogo() throws EncryptedDocumentException, IOException
	{
		WebElement mohfwLogo1                = driver.findElement(By.xpath(ReadExcel.readExcelFile(1, 1)));
		return mohfwLogo1.isDisplayed();
	
	}
	public boolean loginToHBIforHP() throws InterruptedException, IOException 
	{
		WebElement loginRegistrationBtn      = driver.findElement(By.xpath(ReadExcel.readExcelFile(2, 1)));
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
		submitBtn.click();
		Thread.sleep(2000);
		System.out.println("Submit Button = " + submitBtn);
		loginWithPasswordBtn.click();
		Thread.sleep(2000);
		passwordTextBox.sendKeys(readPropertyFile("password"));
		Thread.sleep(2000);
		loginBtn2.click();

		Thread.sleep(2000);
		return logoutBtn.isDisplayed();    
		
	}
}
