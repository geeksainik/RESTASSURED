package restAssureTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class WeatherForecastTest {
	
	public void weathertest() {
		
		Response resp=RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	    
		int status=resp.getStatusCode();
		Assert.assertEquals(status, 200);
		System.out.println(resp.getBody().asString());
	}

}
