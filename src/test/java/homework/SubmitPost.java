package homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class SubmitPost {


//	2. Create a request data object and set values 
	@Test
	public void submitPost() throws IOException {
	SubmitPostRequestBuilder requestData = new SubmitPostRequestBuilder();
	requestData.setUser_id(2222);
	requestData.setTitle("API test");
	requestData.setBody("Today we learn serialization");
	
//	3. Convert request data object to String and print it
	ObjectMapper objMapper = new ObjectMapper();
	String reqDataString = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestData);
	System.out.println(reqDataString);
	
//	4. Submit POST request and get response
	String url = "https://gorest.co.in/public/v1/posts";
	Response resp = given()
						.body(reqDataString)
						.contentType(ContentType.JSON)
						.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
					.when()
						.post(url);
	resp.prettyPrint();
	
//	5. Validate response status code is 201
	assertEquals(201, resp.getStatusCode());
	
//	6. Validate your response data is not null
	assertNotNull(resp);
	
//	7. Write your response data to an external json file
	String filePath = "src/test/resources/testData/GorestResponseData.json";
	File myFile = new File(filePath);
	FileUtils.writeStringToFile(myFile, resp.asPrettyString());
	
	
	}

}
