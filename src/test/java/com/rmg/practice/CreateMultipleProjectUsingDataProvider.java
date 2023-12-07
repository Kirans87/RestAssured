package com.rmg.practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import io.restassured.http.ContentType;
import pojoclass.ProjectLibrary;

public class CreateMultipleProjectUsingDataProvider {
	
	@Test(dataProvider ="getData" )
	public void createMultipleProjectUsingDataProvider(String createdBy, String projectName, String status, int teamSize) {
		ProjectLibrary pl = new ProjectLibrary(createdBy, projectName, status, teamSize);
		

		baseURI ="http://localhost";
		port= 8084;
		
		given().contentType(ContentType.JSON).body(pl)
		.when().post(EndPoints.addProject)
		.then().assertThat().statusCode(201).log().all();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object [][]  obj = new Object [3][4];
		
		obj[0][0] = "Rohith";
		obj[0][1] = "double hundred";
		obj[0][2] = "completed";
		obj[0][3] = 1;
		obj[1][0] = "Sachin";
		obj[1][1] = "hundred centuries";
		obj[1][2] = "completed";
		obj[1][3] = 1;
		obj[2][0] = "Dhoni";
		obj[2][1] = "T20 WC";
		obj[2][2] = "created";
		obj[2][3] = 11;
		
		return obj;
		
	}

}
