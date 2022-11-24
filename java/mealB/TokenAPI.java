package mealB;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import requestBuilder.MealBTokenRequestBuilder;
import utils.FunctionLibrary;

import static io.restassured.RestAssured.given;

public class TokenAPI extends FunctionLibrary {
	
	
	@Test
	public void testTokenAPIMethods() {
		// 3 ways to use reuseable methods 
		// 1- create object then call method
		// 2- use inheritance method - extend and import
		// 3- use static method and call with class name
		generateToken();
		
	}
	
	
	
	
	@Ignore
	@Test
	public void testTokenAPI() throws JsonProcessingException {
		String url = "http://dev-mb.yoll.io/api/tokenauth/authenticate";
		
//		String bodyData = "{\r\n"
//				+ "    \"usernameOrEmailAddress\": \"mealbcompany\",\r\n"
//				+ "    \"password\": \"Test123!\"\r\n"
//				+ "}";
		
		MealBTokenRequestBuilder getTokenData = new MealBTokenRequestBuilder();
		getTokenData.setUsernameOrEmailAddress("mealbcompany");
		getTokenData.setPassword("Test123!");

		
		ObjectMapper objMap = new ObjectMapper();
		String bodyData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(getTokenData);
		System.out.println(bodyData);
		
		Response getToken = given()
								.body(bodyData)
								.contentType(ContentType.JSON)
							.when()
								.post(url);
		getToken.prettyPrint();
		
		
	}
	

}
