package TestCases_API;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken extends TestBase
{
	@Test
	public void bearerToken() throws IOException
	{
		RestAssured.baseURI = readPropertyFile("BearerToken");
		RequestSpecification request = RestAssured.given();
		
		JSONObject payload = new JSONObject();
	    payload.put("username", "TOOLSQA_Test");
		payload.put("password", "Test@@123");
		
		request.header("Content-Type", "application/json");
		Response responseToken = request.body(payload).post("/Account/v1/GenerateToken");
		responseToken.prettyPrint();  // to print the response
		
		//converting the response to string
		String jsonString = responseToken.getBody().asString();
		
		//to extract the token from response
		String generatedToken = JsonPath.from(jsonString).get("token");
		
		//providing this token as a header to POST request
		request.header("Authorization", "Bearer" +generatedToken).
		contentType("application/json");
		
		//payload for the post req
		JSONObject addBody = new JSONObject();
	//	addBody.put(, );
		Response addBookResponse = request.body(addBody).post("/BookStore/v1/Books");
		
		//verifications
		Assert.assertEquals(201, addBookResponse.getStatusCode());
		
		
		
	}

}
