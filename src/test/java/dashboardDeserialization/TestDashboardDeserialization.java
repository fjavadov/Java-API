package dashboardDeserialization;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import utils.FunctionLibrary;

public class TestDashboardDeserialization extends FunctionLibrary{

	@Test
	public void testDashboard() throws JsonMappingException, JsonProcessingException {
		
		// Submit GET response to Dashboard API
		String personalInfo = "http://dev-mb.yoll.io/api/dashboard";
		Response response = given()
								.header("Authorization", "Bearer " + getToken() )
							.when()
								.get(personalInfo);
		response.prettyPrint();
		
		// pars response to JAVA OBJECT - DESERIALIZATION
		ObjectMapper objMapper = new ObjectMapper();
		DashboardResponse dashboardResponse = objMapper.readValue(response.asString(), DashboardResponse.class);
		
		System.out.println(dashboardResponse.is__abp());
		System.out.println(dashboardResponse.isSuccess());
		System.out.println(dashboardResponse.isUnAuthorizedRequest());
		System.out.println(dashboardResponse.getResult().getOtherExpenses());
		
		Map<String, Object> resultValues = JsonPath.read(response.asString(), "$.result");
		System.out.println(resultValues);
		for (String keys : resultValues.keySet()) {
			System.out.println(keys + ": " + resultValues.get(keys));
		}
		
	}
}
