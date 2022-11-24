package homework.weather;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jayway.jsonpath.JsonPath;

public class OpenWeather {

	@Test
	public void getWeatherInfo() {
		String url = "https://api.openweathermap.org/data/2.5/weather";
		
// Submit GET request to OpenWeather api by using CityID
		Response getRespCityID = given()
									.param("id", "5128581")
									.param("appid", "eb42dcaceec223e47753a78413ac3f8b")
								.when()
									.get(url);

		getRespCityID.prettyPrint();
		
//Submit GET request to OpenWeather api by using City Lon and City lat.		
		Response getRespCityLonLat = given()
										.param("lon", "-74.006")
										.param("appid", "eb42dcaceec223e47753a78413ac3f8b")
										.param("lat", "40.7143")
									.when()
										.get(url);
		getRespCityLonLat.prettyPrint();
		
//Validate both API response status codes are 200.
		assertEquals(200, getRespCityID.getStatusCode());
		assertEquals(200, getRespCityLonLat.getStatusCode());
		
// Both APIs return weather forecast for New York:  (Validate city name is New York in response)	
		String name1 = JsonPath.read(getRespCityID.asString(), "$.name");
		String name2 = JsonPath.read(getRespCityLonLat.asString(), "$.name");
		assertEquals("New York", name1);
		assertEquals("New York", name2);
		
		
//Validate following information is matching in both API responses:
		//weather[0].main
		String weatherMain1 = JsonPath.read(getRespCityID.asString(), "$.weather[0].main");
		String weatherMain2 = JsonPath.read(getRespCityLonLat.asString(), "$.weather[0].main");
		assertEquals("Information is not matching in both API responses",weatherMain1, weatherMain2);
		
		//weather[0].description
		String weatherDescription1 = JsonPath.read(getRespCityID.asString(), "$.weather[0].description");
		String weatherDescription2 = JsonPath.read(getRespCityLonLat.asString(), "$.weather[0].description");
		assertEquals("Information is not matching in both API responses",weatherDescription1, weatherDescription2);
		
		//wind.speed
		double windSpeed1 = JsonPath.read(getRespCityID.asString(), "$.wind.speed");
		int windSpeedInt1 = (int)Math.round(windSpeed1);
		double windSpeed2 = JsonPath.read(getRespCityLonLat.asString(), "$.wind.speed");
		int windSpeedInt2 = (int)Math.round(windSpeed2);
		assertEquals("Information is not matching in both API responses", windSpeedInt1, windSpeedInt2);
		//OR
		Double windSpeed3 = JsonPath.read(getRespCityID.asString(), "$.wind.speed");
		Double windSpeed4 = JsonPath.read(getRespCityLonLat.asString(), "$.wind.speed");
		assertEquals("Information is not matching in both API responses", windSpeedInt1, windSpeedInt2);
	
		//main.humidity
		int mainHumidity1 = JsonPath.read(getRespCityID.asString(), "$.main.humidity");
		int mainHumidity2= JsonPath.read(getRespCityLonLat.asString(), "$.main.humidity");
		assertEquals("Information is not matching in both API responses", mainHumidity1, mainHumidity2);
		
		//main.pressure
		int mainPressure1 = JsonPath.read(getRespCityID.asString(), "$.main.pressure");
		int mainPressure2 = JsonPath.read(getRespCityLonLat.asString(), "$.main.pressure");
		assertEquals("Information is not matching in both API responses",mainPressure1, mainPressure2);

		
	}
}
