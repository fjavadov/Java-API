package readWriteFile;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class TestReadWrite {
	
	/*
	 * 1. Read RequestDataFile and assign it to a string variable
	 * 2. Submit Post Request to Gorest API
	 * 3. Write response to ResponseDataFile
	 */
	
	
	@Test
	public void testReadWrite() throws IOException {

// 1. Read RequestDataFile and assign it to a string variable
		String requestedFilePath = "src/test/resources/testData/GorestRequestData.json";
		File reqFile = new File(requestedFilePath);
		String reqData = FileUtils.readFileToString(reqFile);
		
		System.out.println(reqData);
		
		String url = "https://gorest.co.in/public/v1/users";
		
		
		
// 2. Submit Post Request to Gorest API
		Response resp = given()
							.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
							.body(reqData)
							.contentType(ContentType.JSON)
						.when()
							.post(url);
		
		resp.prettyPrint();
		
		// validate status code by rest assured
		resp.then().statusCode(201);					
		// validate status code by Junit assertions
		assertEquals(201,resp.getStatusCode() );
		
		
// 3. Write response to ResponseDataFile
		String responseFilePath = "src/test/resources/testData/GorestResponseData.json";
		File respFile = new File(responseFilePath);
		
		 // write reponse data to file
		FileUtils.writeStringToFile(respFile, resp.asPrettyString());
		
	}
	
	

}
