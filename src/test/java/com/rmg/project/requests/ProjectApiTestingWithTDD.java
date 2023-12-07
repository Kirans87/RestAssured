package com.rmg.project.requests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("unchecked")


public class ProjectApiTestingWithTDD {
	
	@Test
	public void addSingleProjectWithCreated() {
	
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "created");
		obj.put("teamSize", 10);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);
		Response resp = res.post("http://localhost:8084/addProject");
		resp.then().assertThat().statusCode(201).log().all();
	}
	
	@Test
	public void addProjectWitONGoingStatus() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "On Going");
		obj.put("teamSize", 10);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);
		Response resp = res.post("http://localhost:8084/addProject");
		resp.then().assertThat().statusCode(201).log().all();
	}
	
	@Test
	public void addProjectWithCompletedStatus() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);
		Response resp = res.post("http://localhost:8084/addProject");
		resp.then().assertThat().statusCode(201).log().all();
	}
	
	@Test
	public void addDuplicateProject() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);
		Response resp = res.post("http://localhost:8084/addProject");
		resp.then().assertThat().statusCode(502).log().all();
	}
	
	@Test
	public void addProjectWithDuplicateID() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("projectId", "TY_PROJ_1004");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);
		Response resp = res.post("http://localhost:8084/addProject");
		resp.then().assertThat().statusCode(502).log().all();
	}
	
	@Test
	public void addPRojectWithTextFromatBody() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.TEXT);
		Response resp = res.post("http://localhost:8084/addProject");
		resp.then().assertThat().statusCode(500).log().all();
	}
	
	@Test
	public void modifyPRojectName() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "ABCD");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		RequestSpecification res = RestAssured.given();
		res.body(obj);
		res.contentType(ContentType.JSON);
		Response resp = res.put("http://localhost:8084/projects/TY_PROJ_1004");
		resp.prettyPrint();
		System.out.println(resp.getStatusCode());
		resp.then().assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void getAllProjects() {
		Response resp = RestAssured.get("http://localhost:8084/projects");
		resp.then().assertThat().statusCode(200).log().all();
	}

}
