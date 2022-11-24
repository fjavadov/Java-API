package deserialization;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.FunctionLibrary;

public class TestDeserialization extends FunctionLibrary {

	
	@Test
	public void test() throws JsonMappingException, JsonProcessingException {
		
		// submit GET request to personal info and get response
		String personalInfo = "http://dev-mb.yoll.io/api/personalinfo";
		Response response = given()
								.header("Authorization", "Bearer " + getToken() )
							.when()
								.get(personalInfo);
		response.prettyPrint();
		
		// DESERIALIZATION
		// convert JSON response to java object(string)
		
		ObjectMapper objMapper = new ObjectMapper();
		PersonalInfoResponse responseObject = objMapper.readValue(response.asString(), PersonalInfoResponse.class);
		
		//Validation of parent elements
		System.out.println(responseObject.is__abp());
		System.out.println(responseObject.isSuccess());
		System.out.println(responseObject.isUnAuthorizedRequest());
		
		
		//Validation of child elements
		System.out.println(responseObject.getResult().getEmailAddress());
		System.out.println(responseObject.getResult().getName());
	}
		
		
	
	
	
	
	
	
}
