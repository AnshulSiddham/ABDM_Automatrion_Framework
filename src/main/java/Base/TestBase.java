package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;

import ExtentReport_Listener.Listener;

public class TestBase extends Listener
{
	public String readPropertyFile(String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\10711204\\Desktop\\First push\\"
		                		+ "ABDM_Automatrion_Framework\\src\\main\\java\\Config\\Config.properties");
		prop.load(file);
		return prop.getProperty(value);			
	}
	
	public static WebDriver driver;	
	public void initialization() throws IOException
	{
		String browserName = readPropertyFile("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\10711204\\Desktop\\First push\\"
			                                       	+ "ABDM_Automatrion_Framework\\Drivers\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions(); 
		opt.addArguments("--disable-notifications"); // to disable browser exception
	//	opt.addArguments("--incognito"); // to run the test in incognito mode 
	//	opt.addArguments("--headless");
		opt.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		opt.addArguments("--no-sandbox"); // Bypass OS security model
		opt.addArguments("disable-infobars"); // disabling infobars
		opt.addArguments("--disable-extensions"); // disabling extensions
		opt.addArguments("--disable-gpu"); // applicable to windows os only
		opt.addArguments("--ignore-certificate-errors");
		opt.addArguments("--disable-popup-blocking");
		opt.addArguments("--disable-default-apps");
		opt.addArguments("--disable-extensions-file-access-check");
		driver = new ChromeDriver(opt);
		}
		else if(browserName.equalsIgnoreCase("gecko"))
		{
			FirefoxOptions opt1 = new FirefoxOptions();
		    opt1.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\10711204\\Desktop\\"
			            		+ "First push\\ABDM_Automatrion_Framework\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(opt1);
		}
			
		
		else if (browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.msedge.driver", "msedgedriver.exe");
			EdgeOptions opt3 = new EdgeOptions();
			opt3.addArguments("--disabled-notifications");
			driver = new EdgeDriver(opt3);
					
		}	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.get(readPropertyFile("url"));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	

}
