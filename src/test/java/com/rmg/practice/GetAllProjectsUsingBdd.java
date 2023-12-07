package com.rmg.practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjectsUsingBdd {
	
	@Test
	public void getAllProjectsUsingBdd() {
		
		when().get("http://localhost:8084/projects")
		.then().assertThat().statusCode(200).log().all();
	}

}
