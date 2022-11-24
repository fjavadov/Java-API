package utils;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import requestBuilder.GorestRequestBuilder;

public class ReusableMethods {
	
	private static final String URL = "https://gorest.co.in/public/v1/users";

// delete method with parameters
	 /**
     *  @author Fuad Javadov
	 *  @param recordID
	 *  @return response
	 *  @see This method is used to delete gorest user
	 */	
	public static Response deleteGorestUser(int recorderID ) {
		Response deleteResponse = given()
									.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
								.when()
									.delete(URL + "/" + recorderID);
		return deleteResponse;
	}
	
	
	
	
// update method with parameters
	/**
	 * @author Fuad Javadov
	 * @param requestData
	 * @param recordID
	 * @return response
	 * @see This method submit PUT to update Gorest user
	 */
	public static Response updateGorestUser(Object requestData, int recorderID) {
		Response updateResponse = given()
									.body(requestData)
									.contentType(ContentType.JSON)
									.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
								.when()
									.put(URL + "/" + recorderID);

		updateResponse.prettyPrint();
		return updateResponse;
		
	}
	
	
	
// get method with parameters
	 /**
     *  @author Fuad Javadov
	 *  @param recordID
	 *  @return response
	 *  @see This method is used to get gorest user by ID
	 */	
	public static Response getGorestByID(int recorderID) {
		Response getResponse = 	given()
									.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
								.when()
									.get(URL + "/" + recorderID);
		
		getResponse.prettyPrint();
		return getResponse;
	}
	
	
// create post method
	 /**
     *  @author Fuad Javadov
	 *  @param requestData
	 *  @return response
	 *  @see This method is used to create gorest user
	 */	
	public static Response createGorestUser(String requestData) {
		Response response = given()
									.body(requestData)
									.contentType(ContentType.JSON)
									.header("Authorization", "Bearer 91077fbcc219da01a32179969a5f6945339e5c33ca961ecb361c2c6fce8ae693")
								.when()
									.post(URL);
		response.prettyPrint();
		return response;
	}
	
	
	
	

// Create Request Data
	public static String createRequestData(String name, String email, String gender, String status) {
		GorestRequestBuilder reqObj = new GorestRequestBuilder();
		reqObj.setName(name);
		reqObj.setEmail(email);
		reqObj.setGender(gender);
		reqObj.setStatus(status);

		String reqData = convertObjectToString(reqObj);
		return reqData;

	}

// Convert Object to String
	/**
	 * @author Fuad Javadov
	 * @param reqObject
	 * @return String
	 * @see Convert request data object to String
	 */
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
