package homework;

import org.junit.Ignore;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class TeacherSolutionAllFemaleAndPage {
	

		
		
		@Test
		public void homeworkSolutionWithCounter(){
			
			
			String url="https://gorest.co.in/public/v1/users";
			//Submit GET request to Gorest API  go get only female user for fist page.
			Response response=given()
								.param("gender", "female")
							  .when()
							     .get(url);
			response.prettyPrint();
			// get total female user count from response
			int totalFemaleUser=JsonPath.read(response.asString(), "$.meta.pagination.total");
			// get total page count from response
			int totalPages=	JsonPath.read(response.asString(), "$.meta.pagination.pages");
			
			//Get all female users in ALL pages.
			
			int counter=0;
			
			for (int i = 1; i <=totalPages ; i++) {
				// Submit request for each page by using 'i' as page number
				  Response resp=given()
									.param("gender", "female")
									.param("page", i)
								 .when()
								 	.get(url);
				//resp.prettyPrint();
				 // get gender value for each page ad into list
				 List<String> pageList=JsonPath.read(resp.asString(), "$.data.[*].gender");
				 

				 // validate female users of each page (page by page)
				 for (String eachValue : pageList) {
					assertEquals("female", eachValue);
					counter++;
				}
				
			}
			
			assertEquals(totalFemaleUser, counter);
		
		
		}


		
		
		@Ignore
		@Test
		public void homeworkSolutionWithList(){
			List<String>allFemaleList=new ArrayList<String>();
			
			String url="https://gorest.co.in/public/v1/users";
			//Submit GET request to Gorest API  go get only female user for fist page.
			Response response=given()
								.param("gender", "female")
							  .when()
							     .get(url);
			response.prettyPrint();
			// get total female user count from response
			int totalFemaleUser=JsonPath.read(response.asString(), "$.meta.pagination.total");
			// get total page count from response
			int totalPages=	JsonPath.read(response.asString(), "$.meta.pagination.pages");
			
			//Get all female users in ALL pages.
			
			for (int i = 1; i <=totalPages ; i++) {
				// Submit request for each page by using 'i' as page number
				  Response resp=given()
									.param("gender", "female")
									.param("page", i)
								 .when()
								 	.get(url);
				//resp.prettyPrint();
				 // get gender value for each page ad into list
				 List<String> pageList=JsonPath.read(resp.asString(), "$.data.[*].gender");
				 
				 allFemaleList.addAll(pageList);
				 			 
				 System.out.println("Total recieved Users: "+allFemaleList.size());
				 // validate female users of each page (page by page)
				 for (String eachValue : pageList) {
					assertEquals("female", eachValue);
				}
				
			}
			
			assertEquals(totalFemaleUser, allFemaleList.size());
		
		
		}
		
	
	

}
