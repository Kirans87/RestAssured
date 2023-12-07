package com.rmg.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	@Test
	public void  deleteProject() {
		
		Response res = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1003");
		res.prettyPrint();
		System.out.println(res.getStatusCode());
		res.then().assertThat().statusCode(204);
	}

}
