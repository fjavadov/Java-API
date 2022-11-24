package gorest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import io.restassured.response.Response;
public class UserList {

	
	@Test
	public void testPageNumber(){
		String url="https://gorest.co.in/public/v1/users";
		
		Response response=given()
						 		.param("page", 2)
						 .when()
					           .get(url);
		
		response.prettyPrint();
		
		// validate status code is 200  --way 1
		assertEquals(200, response.getStatusCode());
		
		// validate status code is 200  --way 2
		response.then().statusCode(200);
		
		// retrieve value of page element from response and validate if it is 2 
		int pageNumber=response.then().extract().path("meta.pagination.page");
		
		System.out.println("PageNumer:  "+pageNumber);
		
		assertEquals(2, pageNumber);
		
		
	}
	
	
	
	
	
	@Ignore
	@Test
	public void testWronUrl() {
		String url = "https://gorest.co.in/public/v1/wrongUrl";
		
		Response resp = given().when().get(url);
		
		resp.prettyPrint();
		
		// validate Status code of 404 not fund
		assertEquals(404, resp.getStatusCode());
		
	}
	
	
	
	@Ignore
	@Test
	public void getGoRestUserList() {
		
		String url = "https://gorest.co.in/public/v1/users";
		
		/*
		 
				// if we want to get all information we need to create Responce Object
				// than we need to use prettyPrint() method
		Response resp = given().when().get(url);
		resp.prettyPrint();

				
				// get status code of response
		resp.getStatusCode();
				// if we want to see the code we need to use syso method
		System.out.println("The Status Code is: " + resp.getStatusCode());
		
		*/
		
		
				// WITH PARAMETERS
		Response resp = given()
								.param("gender", "female")
								.param("status", "active")
								.header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjExMjAxIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im1lYWxiY29tcGFueSIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiNDI1NzA2YmQtMjBlYi00NjFhLTkyZGYtZTE4ZjE2M2EyNWExIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiQ29tcGFueSIsImh0dHA6Ly93d3cuYXNwbmV0Ym9pbGVycGxhdGUuY29tL2lkZW50aXR5L2NsYWltcy90ZW5hbnRJZCI6IjEiLCJzdWIiOiIxMTIwMSIsImp0aSI6ImIwNGFhODhlLTlmYjgtNGU1ZS1hYWE4LTUwNDIxMjYyMWI5YyIsImlhdCI6MTY2MjAxOTc5OCwibmJmIjoxNjYyMDE5Nzk4LCJleHAiOjE2OTM1NTU3OTgsImlzcyI6Ik1lYWxCIiwiYXVkIjoiTWVhbEIifQ.GcHXQC7wJktXffvJD3XDwgDcd6T_plCp6PhhuR2ItG4")
								
						.when()
								.get(url); // we need to use what method we want to use: get, post, put, patch, delete
		
		
		resp.prettyPrint();
		
		// validate that response is not null
		assertNotNull(resp);
		
		
		System.out.println("The Status Code is: " + resp.getStatusCode());
		
		//validate the Status code is right, means 200
		assertEquals(200, resp.getStatusCode());
		
				
	}
	
	
	
	
	
	
	
	
}
