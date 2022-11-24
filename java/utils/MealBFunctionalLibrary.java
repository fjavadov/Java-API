package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.util.List;

import requestBuilder.MealBOtherExpenseRequestBuilder;

public class MealBFunctionalLibrary extends FunctionLibrary {
	
	public static Response resp;
	
	public Response createOtherExpens(String id) throws JsonProcessingException {
		MealBOtherExpenseRequestBuilder reqObj = new MealBOtherExpenseRequestBuilder();
		reqObj.setName("Disneyland ticket");
		reqObj.setAmount("45475.00");
		reqObj.setExpenseDateTime("01/28/2021 00:00:00");
		reqObj.setExpenseType("Other");
		reqObj.setOtherExpenseNameId(id);
		
		ObjectMapper objMap = new ObjectMapper();
		String reqData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(reqObj);
		
		
		String url = "http://dev-mb.yoll.io/api/expenses/create";
		 resp =  given()
							.body(reqData)
							.contentType(ContentType.JSON)
							.header("Authorization", "Bearer " + getToken() )
						.when()
							.post(url);
		resp.prettyPrint();
			
		return resp;
		
	}
	
	
	
	public static Response respInfo;
	public Response getMealBInfo(String url) {
		
		
		 respInfo = given()
							.header("Authorization", "Bearer " + getToken())
						.when()
							.get(url);
		respInfo.prettyPrint();
			
		return respInfo;
		
	}
	
	
	public static Double totalExpense;
	public Double getTotalExpense(List<Double>  otherExpense) {
	
		DecimalFormat df = new DecimalFormat("#.##");      
		totalExpense = 0.0;
		for (int i = 0; i < otherExpense.size(); i++) {
			totalExpense += otherExpense.get(i);
		}
		totalExpense=Double.valueOf(df.format(totalExpense));
		return totalExpense;
	}
	
	
	
}
