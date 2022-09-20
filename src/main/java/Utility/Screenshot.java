package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class Screenshot extends TestBase
{
//	public static String screenshot(String name) throws IOException
//	{
//		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File dest = new File("C:\\Users\\10711204\\eclipse-workspace\\Automation_UI\\"
//		           		+ "Screenshots_Failed\\"+name+".png");
//		FileUtils.copyFile(source, dest);
//	    FileHandler.copy(source, dest); 
//		return dest.getAbsolutePath();
//		
//	}
	public static String getScreenshot(String name) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyyddmmhhmmss").format(new Date());
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\10711204\\eclipse-workspace\\Automation_UI\\"
		           		+ "Screenshots_Failed\\"+name+".png");
		FileUtils.copyFile(source, dest);
//	    FileHandler.copy(source, dest); 
		return dest.getAbsolutePath();
		
	}
	
	public static String getDate()
	{
		Date date = new Date();
		return date.toString();
	}

}
