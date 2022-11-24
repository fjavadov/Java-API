package mealB;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.response.Response;
import utils.FunctionLibrary;

public class DashboardAPI extends FunctionLibrary {

	
	@Test
	public void getDashboardInfo() {
		String DashboardInfoURL = "http://dev-mb.yoll.io/api/dashboard";
		Response resp = given()
							.header("Authorization", "Bearer " + getToken())
						.when()
							.get(DashboardInfoURL);
		resp.prettyPrint();
	}
}
