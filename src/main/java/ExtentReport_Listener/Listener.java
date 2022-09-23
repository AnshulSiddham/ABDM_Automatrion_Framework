package ExtentReport_Listener;


import java.io.IOException;

import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Screenshot;

public class Listener
{
	 protected ExtentReports extent;
	 protected ExtentTest test;

	public void beforeSuit()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "LTILPUN22001550");
		extent.addSystemInfo("User Name", "Anshul");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("OS", "Windows 10");
	}
	
	public void afterSuit()
	{
		extent.flush();
	}
	
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "TEST CASE FAILED IS " +result.getName());
			test.log(LogStatus.FAIL, "TEST CASE ERROR IS " +result.getThrowable()); // to add error and exception to extent report
			
			String screeshotPath = Screenshot.getScreenshot(result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screeshotPath)); // to add screenshot to extent report
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, "TEST CASE SKIPPED IS " +result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "TEST CASE PASSED IS " +result.getName());
		}
		
		extent.endTest(test); // ending the test and prepare html report
		
	}
	
	
	
}	 

