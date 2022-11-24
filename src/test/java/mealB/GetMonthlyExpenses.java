package mealB;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.response.Response;
import utils.FunctionLibrary;

public class GetMonthlyExpenses extends FunctionLibrary {
	
	
	@Test
	public void MonthlyExpenses() {
		
		String monthlyExpensesURL = "http://dev-mb.yoll.io/api/expenses/getMonthlyExpenses";
		
		Response resp = given()
							.header("Authorization", "Bearer " + getToken())
						.when()
							.get(monthlyExpensesURL);
		resp.prettyPrint();
		
	}
}
