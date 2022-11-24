package jsonPath;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import com.jayway.jsonpath.JsonPath;

import java.util.List;

import org.junit.Test;

public class GorestTestScenarios {
	
	@Test
	public void validateGender() {
// Submit GET request and get Female users
	String url = "https://gorest.co.in/public/v1/users";
	Response resp = given()
						.param("gender","female")
					.when()
						.get(url);
	resp.prettyPrint();
	
// Validate if all received users are female
	List<String> genderList=JsonPath.read(resp.asString(), "$.data[*].gender");
	System.out.println(genderList);
	
	for (String eachValue : genderList) {
		assertEquals("female", eachValue);
	}
	
	
	}
	
	@Test
	public void validateUserCount() {
// submit Get request 
			String url="https://gorest.co.in/public/v1/users";
			Response response=given().when().get(url);
			response.prettyPrint();
			
//// retrieve users from response and assign them to a list
//			List<String> userList=JsonPath.read(response.asString(), "$.data[*]");
//			System.out.println(userList);
//			System.out.println(userList.size());
//			
//// get size of the list and validate if count of users is 10
//			assertEquals(10, userList.size());
			
	}
	

}
