package com.rmg.practice;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class DeleteProjectUsingBdd {
	
	@Test
	public void deleteProjectUsingBdd() {
		when().delete("http://localhost:8084/projects/TY_PROJ_402")
		.then().assertThat().statusCode(204).log().all();
	}

}
