package com.rmg.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProject() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Kiran");
		obj.put("projectName", "warpSpeed");
		obj.put("status", "created");
		obj.put("teamSize", 8);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);
		Response resp = res.post("http://localhost:8084/addProject");
		resp.prettyPrint();
		System.out.println(resp.getStatusCode());
	}

}
