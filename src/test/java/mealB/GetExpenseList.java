package mealB;

import org.junit.Test;

import io.restassured.response.Response;
import utils.FunctionLibrary;

import static io.restassured.RestAssured.given;

public class GetExpenseList extends FunctionLibrary{
	
	
	@Test
	public void getExpenseList() {
		
		String getExpenseListURL = "http://dev-mb.yoll.io/api/expenses";
// String token = getToken();we can create string and pass the string or we can use directly method
		
		Response resp = given()
							.header("Authorization", "Bearer " + getToken())
						.when()
							.get(getExpenseListURL);
		resp.prettyPrint();
		
	}

}
