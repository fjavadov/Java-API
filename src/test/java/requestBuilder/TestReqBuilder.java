package requestBuilder;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestReqBuilder {

	@Test
	public void createReqdata() throws JsonProcessingException {

		// set json values to java object 
		GorestRequestBuilder reqBuilder = new GorestRequestBuilder();
			reqBuilder.setName("Fred API");
			reqBuilder.setEmail("fredapi@gmail.com");
			reqBuilder.setGender("male");
			reqBuilder.setStatus("active");
			
							// ******* Serialization ******
			// Convert java  object to String
			ObjectMapper objMap = new ObjectMapper();
			String jsonData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(reqBuilder);
			
			System.out.println(jsonData);

	}

}
