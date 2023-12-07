package com.rmg.practice;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetSingleProjectsUsingBdd {
	
	@Test
	public void getAllProjectsUsingBdd() {
		
		when().get("http://localhost:8084/projects/TY_PROJ_1004")
		.then().assertThat().statusCode(200).log().all();
	}

}
