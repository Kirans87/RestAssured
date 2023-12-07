package com.rmg.practice;

import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import GenericLibrary.IPathConstant;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CreateProjectWithJsonFile {
	
	@Test
	public void createProjectWithJsonFile() throws FileNotFoundException {
		FileInputStream fi = new FileInputStream(IPathConstant.JSONFILEPATH);
		
		baseURI ="http://localhost";
		port= 8084;
		
		given().contentType(ContentType.JSON).body(fi)
		.when().post(EndPoints.addProject)
		.then().assertThat().statusCode(201).log().all();
		
	}

}
