package com.rmg.project.requests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
	
@SuppressWarnings("unchecked")
public class ProjectApiTestingWithBDD {
	
	@Test
	public void addSingleProjectWithCreated() {
		
		baseURI="http://localhost";
		port = 8084;
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "created");
		obj.put("teamSize", 10);
		
		given().body(obj).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
	
	@Test
	public void addProjectWitONGoingStatus() {
		baseURI="http://localhost";
		port = 8084;
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "On Going");
		obj.put("teamSize", 10);
		
		given().body(obj).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
	
	@Test
	public void addProjectWithCompletedStatus() {
		baseURI="http://localhost";
		port = 8084;
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		given().body(obj).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
	
	@Test
	public void addDuplicateProject() {
		baseURI="http://localhost";
		port = 8084;
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		given().body(obj).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(502).log().all();
	}
	
	@Test
	public void addProjectWithDuplicateID() {
		baseURI="http://localhost";
		port = 8084;
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("projectId", "TY_PROJ_1004");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		given().body(obj).contentType(ContentType.JSON)
		.when().post("/addProject")
		.then().assertThat().statusCode(502).log().all();
	}
	
	@Test
	public void addPRojectWithTextFromatBody() {
		baseURI="http://localhost";
		port = 8084;
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "deepak_pro-1");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		given().body(obj).contentType(ContentType.TEXT)
		.when().post("/addProject")
		.then().assertThat().statusCode(500).log().all();
	}
	
	@Test
	public void modifyProjectName() {
		baseURI="http://localhost";
		port = 8084;
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "deepak");
		obj.put("projectName", "ABD");
		obj.put("status", "completed");
		obj.put("teamSize", 10);
		
		given().body(obj).contentType(ContentType.JSON)
		.when().put("/projects/TY_PROJ_1004")
		.then().assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void getAllProjects() {
		baseURI="http://localhost";
		port = 8084;
		when().get("/projects")
		.then().assertThat().statusCode(200).log().all();
	}
	
	
}
