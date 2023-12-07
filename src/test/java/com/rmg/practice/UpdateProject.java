package com.rmg.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProject() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Kiran");
		obj.put("projectName", "warpSpeed");
		obj.put("status", "On Going");
		obj.put("teamSize", 18);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);
		Response resp = res.put("http://localhost:8084/projects/TY_PROJ_1002");
		resp.prettyPrint();
		System.out.println(resp.getStatusCode());
		resp.then().assertThat().statusCode(200).log().all();
	}

}
