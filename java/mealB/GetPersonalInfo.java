package mealB;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.response.Response;
import utils.FunctionLibrary;

public class GetPersonalInfo extends FunctionLibrary{

	
	
	@Test
	public void MonthlyExpenses() {
		
		String personalInfURL = "http://dev-mb.yoll.io/api/personalinfo";
		
		Response resp = given()
							.header("Authorization", "Bearer " + getToken())
						.when()
							.get(personalInfURL);
		resp.prettyPrint();
		
	}
}
