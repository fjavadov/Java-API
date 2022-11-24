package gorest;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUser {
	
	@Test
	public void addNewUser(){
		String url="https://gorest.co.in/public/v1/users";
		String regBody = "{\n"
				+ "    \"name\": \"AAAA BBB\",\n"
				+ "    \"email\": \"ABBACA@gmail.com\",\n"
				+ "    \"gender\": \"male\",\n"
				+ "    \"status\": \"active\"\n"
				+ "}";
		

		
		Response response=given()
				// when we suse POST or PUT or PATCH request we need to use contentType method. 
				// because we need to use JSON format
							 .contentType(ContentType.JSON)
							//.header("Content-Type","application/json")
							 .header("Authorization","Bearer 1b0a651f0ee6151ed5586b675cd871b4178f23f1ee6900f0fb7a34d787ac1855")
							 .body(regBody)
					      .when()
					          .post(url);
		
		response.prettyPrint();
		
		// validate response content type:
		response.then().contentType(ContentType.JSON);
		
		System.out.println(response.getStatusCode());
		
	}

	
	
}
