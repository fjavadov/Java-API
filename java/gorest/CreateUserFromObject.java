package gorest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import requestBuilder.GorestRequestBuilder;

public class CreateUserFromObject {
	
	/*
	 * 1. Create a json data from Object
	 * 2. Convert object to String
	 * 3. Submit Post request
	 * 4. Validate status code 
	 */
	
	@Test
	public void creteUserFromJavaObject() throws JsonProcessingException {
		
// 1. Create a json data from Object
		GorestRequestBuilder reqObj=new GorestRequestBuilder();
			reqObj.setName("Titan+Avangers");
			reqObj.setEmail("titanA54vangers@yoll.com");
			reqObj.setGender("male");
			reqObj.setStatus("active");
			
// 2. Convert object to String
		ObjectMapper objMap = new ObjectMapper();
		String requestData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(reqObj);
		System.out.println(requestData);
		
		
// 3. Submit Post request
		String url = "https://gorest.co.in/public/v1/users";
		Response resp = given()
							.body(reqObj) // or we can use string version requestData
							.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
							.contentType(ContentType.JSON)
						.when()
							.post(url);
		resp.prettyPrint();
		
// 4. Validate status code 
		assertEquals(201, resp.getStatusCode());
		
	}

}
