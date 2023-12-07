package com.rmg.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectusingBdd {
	
	@Test
	public void updateProjectusingBdd() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Kiran");
		obj.put("projectName", "warpSpeed");
		obj.put("status", "completed");
		obj.put("teamSize", 18);

		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1004")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}

}
