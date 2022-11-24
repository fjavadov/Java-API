package homework.mealB;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.apache.commons.io.output.ProxyOutputStream;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import requestBuilder.MealBOtherExpenseRequestBuilder;
import utils.MealBFunctionalLibrary;

public class MealBCreateExpenseAPI extends MealBFunctionalLibrary {

	@Test
	public void mealBCreateExpense() throws JsonProcessingException {
		
//Scenario 1: otherExpenseNameId :1
		createOtherExpens("1");
		String name1 = JsonPath.read(MealBFunctionalLibrary.resp.asString(), "$.result.name");
		assertEquals(200, MealBFunctionalLibrary.resp.getStatusCode());
		assertEquals("Electricity", name1);

//Scenario 2: otherExpenseNameId :2
		createOtherExpens("2");
		String name2 = JsonPath.read(MealBFunctionalLibrary.resp.asString(), "$.result.name");
		assertEquals(200, MealBFunctionalLibrary.resp.getStatusCode());
		assertEquals("Rent", name2);

//Scenario 3: otherExpenseNameId 3:
		createOtherExpens("3");
		String name3 = JsonPath.read(MealBFunctionalLibrary.resp.asString(), "$.result.name");
		assertEquals(200, MealBFunctionalLibrary.resp.getStatusCode());
		assertEquals("Gas", name3);

//Scenario 4: otherExpenseNameId 4:
		createOtherExpens("4");
		String name4 = JsonPath.read(MealBFunctionalLibrary.resp.asString(), "$.result.name");
		assertEquals(200, MealBFunctionalLibrary.resp.getStatusCode());
		assertEquals("Disneyland ticket", name4);

//Scenario 5: otherExpenseNameId 5:
		createOtherExpens("5");
		String errorMessage = JsonPath.read(MealBFunctionalLibrary.resp.asString(), "$.error.message");
		assertEquals(500, MealBFunctionalLibrary.resp.getStatusCode());
		assertEquals("An internal error occurred during your request!", errorMessage);

		
////Scenario 6: Negative
		createOtherExpens("");
		assertEquals(400, MealBFunctionalLibrary.resp.getStatusCode());
		String expectedErrorMessage = "The OtherExpenseNameId field is required by the following logic: ExpenseType==ExpenseType.Other";
		String actualErrorMessage = JsonPath.read(MealBFunctionalLibrary.resp.asString(), "$.error.validationErrors[0].message");
		assertEquals(expectedErrorMessage, actualErrorMessage);

	}

}
