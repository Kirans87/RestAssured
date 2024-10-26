package sample.api.practice;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RestApiExamplesGet {
	
	@Test
	public void GetEmployee() {
		when().get("http://dummy.restapiexample.com/api/v1/employee/1").then().assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void createEmployee() { 
		
		JSONObject obj = new JSONObject();
		obj.put("name","Kiran");
		obj.put("salary","15LPA");
		obj.put("age","27");
		given().body(obj).contentType(ContentType.JSON)
		.when().post("http://dummy.restapiexample.com/api/v1/create").then().assertThat().statusCode(201).log().all();
	}


}
