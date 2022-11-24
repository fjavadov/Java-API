package gorest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given; 
import requestBuilder.GorestRequestBuilder;

public class EndToEndScenario {
	
	/*
	 * 1. Create a GorestUser with POST method
	 * 2. Validate new User is created by GET by ID method
	 * 3. Update userName and Status with PUT method
	 * 4. Validate newUser is updated by Get by ID method
	 * 5. Delete user by DELETE method
	 * 6. Validate the user is deleted by GET by ID method
	 * 
	 */
	
	@Test
	public void testEnd2EndScenario() throws JsonProcessingException {
		
		String url = "https://gorest.co.in/public/v1/users";
		
// 1 - Create a GorestBuilder with POST method
		// Create Request Data
		GorestRequestBuilder reqObj = new GorestRequestBuilder();
		reqObj.setName("Cohort 8 API Test");
		reqObj.setEmail("apitester205@gmail.com");
		reqObj.setGender("female");
		reqObj.setStatus("active");

		
// Convert Object to String
		ObjectMapper objMapp = new ObjectMapper();
		String strReqData = objMapp.writerWithDefaultPrettyPrinter().writeValueAsString(reqObj);
		System.out.println(strReqData);
		
		
// Submit POST Request
		Response postResponse = given()
							.body(strReqData)
							.contentType(ContentType.JSON)
							.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
							.when()
								.post(url);
		postResponse.prettyPrint();
		
		
		
// retrive recorded ID from rsponse
		int recorderID = JsonPath.read(postResponse.asString(), "$.data.id");
		

// 2 - Validate new User is created by GET by ID method
		Response getResponse = given()
							.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
						.when()
							.get(url + "/" + recorderID);
		assertEquals(200, getResponse.getStatusCode());
		
		
		
		
// 3 - Update userName and Status with PUT method
		GorestRequestBuilder updateObj = new GorestRequestBuilder();
		updateObj.setName("Cohort 8 Titans and Avengers");
		updateObj.setEmail("apitester205@gmail.com");
		updateObj.setGender("female");
		updateObj.setStatus("inactive");
		
		// this part is optional
		ObjectMapper updateObjMapp = new ObjectMapper();
		String strReqDataUpdate = updateObjMapp.writerWithDefaultPrettyPrinter().writeValueAsString(updateObj);
		System.out.println(strReqDataUpdate);
		
		// submit PUT request
		Response updateResponse = given()
				.body(updateObj)
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
				.when()
					.put(url + "/" + recorderID);
		
		updateResponse.prettyPrint();
		
		assertEquals(200, updateResponse.getStatusCode());
		
		
		
		
// 4 - Validate newUser is updated	
		
		Response getResponse2 = given()
				.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
			.when()
				.get(url + "/" + recorderID);
			assertEquals(200, getResponse2.getStatusCode());
		
		// validate if the name is UPDATED
		String updatedUserName = JsonPath.read(getResponse2.asString(), "$.data.name");
		assertEquals("Cohort 8 Titans and Avengers", updatedUserName);
		
		
		
// 5 - Delete user by DELETE method
		Response deleteResponse = given()
				.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
			.when()
				.delete(url + "/" + recorderID);
		assertEquals(204, deleteResponse.getStatusCode());
		
		System.out.println(deleteResponse.getStatusCode());
		
		
		
// 6 - Validate the user is deleted by GET by ID method	
		
		Response getResponse3 = given()
				.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
			.when()
				.get(url + "/" + recorderID);
			assertEquals(404, getResponse3.getStatusCode());
		
			System.out.println(getResponse3.getStatusCode());
			
	// validate error message
			String errorMessage = JsonPath.read(getResponse3.asString(), "$.data.message");
			assertEquals("Resource not found", errorMessage );
	}

}
