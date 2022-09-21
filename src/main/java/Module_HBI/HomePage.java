package Module_HBI;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.TestBase;
import Utility.ReadExcel;

public class HomePage extends TestBase
{
	public String profile() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebElement profileOpt = driver.findElement(By.xpath(ReadExcel.readExcelFile(22, 1)));
		profileOpt.click();
		Thread.sleep(2000);
		WebElement emailID = driver.findElement(By.xpath(ReadExcel.readExcelFile(23, 1)));
		return emailID.getText();
	}

}
