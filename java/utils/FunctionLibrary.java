package utils;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import requestBuilder.MealBTokenRequestBuilder;

public class FunctionLibrary {
	
	private final String USERNAME = "mealbcompany";
	private final String PASSWORD = "Test123!";
	private final String tokenURL = "http://dev-mb.yoll.io/api/tokenauth/authenticate";
	
	
// get only token to use in the body
	public String getToken() {
		String token = JsonPath.read(generateToken(), "$.result.accessToken");
		return token;
	}
	
	
// create Token method
	public String generateToken() {
		
		String reqData = createTokenRequestData();
		Response respToken = given()
								.body(reqData)	//or .body(createTokenRequestData());
								.contentType(ContentType.JSON)
							.when()
								.post(tokenURL);
		return respToken.prettyPrint();
	}
	
	
	
// create method for TOKEN Request Payload(data)
	public String createTokenRequestData() {
		MealBTokenRequestBuilder getTokenData = new MealBTokenRequestBuilder();
			getTokenData.setUsernameOrEmailAddress(USERNAME);
			getTokenData.setPassword(PASSWORD);
		
		// convert object to string, print and return it in console
			String payload = convertObjectToString(getTokenData);
			System.out.println(payload);
		return payload;
	}
	
	
	// Convert Object to String
		public static String convertObjectToString(Object reqObject) {
			String strReqData = null;
			try {
				ObjectMapper objMapp = new ObjectMapper();
				strReqData = objMapp.writerWithDefaultPrettyPrinter().writeValueAsString(reqObject);

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return strReqData;
		}


}
