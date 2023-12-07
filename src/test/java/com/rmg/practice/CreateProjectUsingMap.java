package com.rmg.practice;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectUsingMap {

	@Test
	public void createProjectUsingMap() {
		
		HashMap obj =  new HashMap();
		obj.put("createdBy", "Kirans");
		obj.put("projectName", "billet");
		obj.put("status", "created");
		obj.put("teamSize", 8);
		System.out.println(obj);
		RequestSpecification req = RestAssured.given();
		
		req.body(obj);
		req.contentType(ContentType.JSON);
		Response res = req.post("http://localhost:8084/addProject");
		res.prettyPrint();
		System.out.println(res.getStatusCode());
		
	}
}
