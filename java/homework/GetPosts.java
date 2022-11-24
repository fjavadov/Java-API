package homework;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetPosts {
	
//	1.Submit GET request  and receive response
	
	@Test
	public void getPosts() throws IOException {
	String url = "https://gorest.co.in/public/v1/posts";
	Response resp = given()
					.when()
						.get(url);
	resp.prettyPrint();
	
//	2. Validate response data is not null
	assertNotNull(resp);
	
//	3. Validate response status code is 200
	assertEquals(200, resp.getStatusCode());
	
//	4. Validate response content type is JSON
	resp.then().contentType(ContentType.JSON);
	
//	5. Retrieve value of "page" element and validate its value is 1
	int pageNumber = resp.then().extract().path("meta.pagination.page");
	assertEquals(1, pageNumber);
	
//	6. Write the response data to an external file (You can create extra json file to write this data)
	String filePath = "src/test/resources/testData/GorestResponseData.json";
	File myData = new File(filePath);
	FileUtils.writeStringToFile(myData, resp.asPrettyString());

	}
}
