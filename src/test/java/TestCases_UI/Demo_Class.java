package TestCases_UI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Base.TestBase;

public class Demo_Class extends TestBase
{
	@Test
    public void functionality1Test1()
    {
        test = extent.createTest("functionality1 Test1");
        Assert.assertTrue(1 > 0);
    }
     
    @Test
    public void functionality1Test2()
    {
        test = extent.createTest("functionality1 zTest2");
        Assert.assertEquals("Krishna", "Sakinala");
    }
    
    @AfterMethod
	public void exit(ITestResult result) throws IOException 
	{	
		getResult(result);
//		afterMethod(result);
		driver.quit();
	}
    
	

}
