package com.rmg.practice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import io.restassured.http.ContentType;
import pojoclass.ProjectLibrary;

public class CreateProjectWithPojoClass {
	

	@Test
	public void createProjectWithPojoClass() {
		ProjectLibrary pl = new ProjectLibrary("Abc", "efg", "created", 18);
		
		baseURI ="http://localhost";
		port= 8084;
		
		given().contentType(ContentType.JSON).body(pl)
		.when().post(EndPoints.addProject)
		.then().assertThat().statusCode(201).log().all();
		
	}
	

}
