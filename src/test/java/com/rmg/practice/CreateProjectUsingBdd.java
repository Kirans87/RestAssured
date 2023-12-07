package com.rmg.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingBdd {
	
	@Test
	public void createProjectusingBdd() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Kiran18");
		obj.put("projectName", "warpSpeed");
		obj.put("status", "created");
		obj.put("teamSize", 8);
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}

}
