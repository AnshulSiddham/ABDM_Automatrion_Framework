package TestCases_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_03
{
	@Test
	public void test_post()
	{
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "Anshul");
		payload.put("job", "Engineer");
		
		httpRequest.accept(ContentType.JSON);
		httpRequest.body(payload);
		
		Response response = httpRequest.post("/users");
		int statusCodeActual = response.statusCode();
		String statusLineExpected = "HTTP/1.1 201 Created";
		String statusLineActual = response.statusLine();
		
		Assert.assertEquals(statusCodeActual, 201);
		Assert.assertEquals(statusLineActual, statusLineActual);
		System.out.println(response.getBody().asString());
		
		
	}

}
