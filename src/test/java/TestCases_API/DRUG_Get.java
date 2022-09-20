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

public class DRUG_Get extends Screenshot
{
	@Test
	public void test_GET() throws EncryptedDocumentException, IOException
	{
		RestAssured.baseURI = readPropertyFile("DRUG_GET");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		Response response = request.get("/v1/drugs/977751000189100");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
	}

}
