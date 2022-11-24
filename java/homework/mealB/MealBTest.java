package homework.mealB;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import requestBuilder.MealBOtherExpenseRequestBuilder;

public class MealBTest {
	
	@Test
	public void createExpenses() {
		
		MealBOtherExpenseRequestBuilder createObject = new MealBOtherExpenseRequestBuilder();
		createObject.setName("Disneyland ticket");
		createObject.setAmount("45475.00");
		createObject.setExpenseDateTime("01/28/2021 00:00:00");
		createObject.setExpenseType("Other");
		
		String url = "http://dev-mb.yoll.io/api/expenses/create";
		 Response negativeResp =  given()
									.body(createObject)
									.contentType(ContentType.JSON)
									.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjExMjAxIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZSI6Im1lYWxiY29tcGFueSIsIkFzcE5ldC5JZGVudGl0eS5TZWN1cml0eVN0YW1wIjoiNDI1NzA2YmQtMjBlYi00NjFhLTkyZGYtZTE4ZjE2M2EyNWExIiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9yb2xlIjoiQ29tcGFueSIsImh0dHA6Ly93d3cuYXNwbmV0Ym9pbGVycGxhdGUuY29tL2lkZW50aXR5L2NsYWltcy90ZW5hbnRJZCI6IjEiLCJzdWIiOiIxMTIwMSIsImp0aSI6ImU5NzVhZTc2LWM4YTgtNDNiMS1hNjA5LWZkMmQyNzBkYzcwYyIsImlhdCI6MTY2MjAwODgzNSwibmJmIjoxNjYyMDA4ODM1LCJleHAiOjE2OTM1NDQ4MzUsImlzcyI6Ik1lYWxCIiwiYXVkIjoiTWVhbEIifQ.z1nVVPIQnkwV7aF9FhIm2wbm0LqeFn3f21MTpIBBwnc" )
								.when()
									.post(url);
		 negativeResp.prettyPrint();
		
		assertEquals(400, negativeResp.getStatusCode());
		
	}


}
