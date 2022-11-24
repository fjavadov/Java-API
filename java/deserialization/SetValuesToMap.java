package deserialization;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import utils.FunctionLibrary;

public class SetValuesToMap extends FunctionLibrary {

	
	@Test
	public void test()  {
		
		// submit GET request to personal info and get response
		String personalInfo = "http://dev-mb.yoll.io/api/personalinfo";
		Response response = given()
								.header("Authorization", "Bearer " + getToken() )
							.when()
								.get(personalInfo);
		response.prettyPrint();
		
		//  Each element one by one
		String name = JsonPath.read(response.asString(), "$.result.name");
		String email = JsonPath.read(response.asString(), "$.result.emailAddress");
		
		// get elements and assign to MAP
		// Object will handle String and Int
		Map<String, Object> resultValues = JsonPath.read(response.asString(), "$.result");
		// print the map
		System.out.println(resultValues);
		
		// to print the KEYs only from map
		System.out.println(resultValues.keySet());
		// to print the VALUES only from map
		System.out.println(resultValues.values());
		
		for (String key : resultValues.keySet()) {
			System.out.println(key + ": " + resultValues.get(key));
		}
		
		
		// Validate values
		System.out.println("*******************");
		System.out.println(resultValues.get("name"));
		System.out.println(resultValues.get("emailAddress"));
		
	}
		
		
}
