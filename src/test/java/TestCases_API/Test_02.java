package TestCases_API;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import Utility.Screenshot;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_02 extends TestBase
{
	@Test
	public void test_GET() throws EncryptedDocumentException, IOException
	{
		RestAssured.baseURI = readPropertyFile("Get"); 
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.param("page", 2);
		
		Response response = httpRequest.get("/users?page=2");
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
		
		String statusLineActual = response.statusLine();
		String statusLineExpected = "HTTP/1.1 200 OK";
		Assert.assertEquals(statusLineActual, statusLineExpected);
		
		
		
	}

}

