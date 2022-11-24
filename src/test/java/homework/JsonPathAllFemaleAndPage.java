package homework;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.jayway.jsonpath.JsonPath;


import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class JsonPathAllFemaleAndPage {

	
	
//	Submit GET request to Gorest API  go get only female user.
//	Get all female users in ALL pages.
//	Validate if all retrieved users are "female"
//	Validate if total count of female users you retrieved from response data matches 
//	with the value in below path: ($.meta.pagination.total)
	@Test
	public void validateAllfamelaGenders() {
		String url = "https://gorest.co.in/public/v1/users";
		List<List<String>> allFemales = new ArrayList<List<String>>();
		int pageTotalNum =1;
		int totalFemaleNum = 0 ;
		for (int i = 1; i <= pageTotalNum; i++) {
			Response rest = given()
								.param("gender", "female")
								.param("page", i)
							.when()
								.get(url);
			pageTotalNum = JsonPath.read(rest.asString(), "$.meta.pagination.pages");
			totalFemaleNum = JsonPath.read(rest.asString(), "$.meta.pagination.total");
			rest.prettyPrint();
			
			List<String> genderList = JsonPath.read(rest.asString(), "$.data[*].gender");
			System.out.println(genderList);
			for (int k = 0; k < genderList.size(); k++) {
				allFemales.add(genderList);
			}

			for (List<String> list : allFemales) {
				for (String eachValue : list) {
					assertEquals("female", eachValue);
					}
			}
			assertEquals(allFemales.size(), totalFemaleNum);
		}
	}
	

	
}
