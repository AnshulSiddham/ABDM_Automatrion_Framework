package TestCases_API;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HBI_Post extends TestBase
{
	@Test
	public void test_Post_HBI() throws IOException
	{
	RestAssured.baseURI = readPropertyFile("HBI_POST");
	RequestSpecification httpRequest = RestAssured.given();
	httpRequest.header("Content-Type", "application/json");
	
	JSONObject payload = new JSONObject();
	payload.put("email", "hireit@gmail.com");
	payload.put("password", "Hireit@123");
	
	httpRequest.accept(ContentType.JSON);
	
	Response response = httpRequest.body(payload).post("/v1/hbi/signin");
	int statusCodeActual = response.statusCode();
	String statusLineExpected = "HTTP/1.1 201 Created";
	String statusLineActual = response.statusLine();
	
	Assert.assertEquals(statusCodeActual, 201);
	Assert.assertEquals(statusLineActual, statusLineActual);
	System.out.println(response.getBody().toString()) ;
	}
}
