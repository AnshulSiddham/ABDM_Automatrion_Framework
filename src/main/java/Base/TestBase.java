package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ExtentReport_Listener.Listener;
import Utility.Screenshot;

//extra code
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestBase extends Listener
{
	// extra code 
	public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
	
    @BeforeSuite
    public void setUp()
    {
        spark = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
         
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Host Name", "LTILPUN22001550");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Anshul Siddham");
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
            
            String screeshotPath = Screenshot.getScreenshot(result.getName());
            test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath(screeshotPath));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }
	
	
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
