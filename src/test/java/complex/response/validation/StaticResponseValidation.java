package complex.response.validation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import GenericLibrary.EndPoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class StaticResponseValidation {
	
	@Test
	public void staticResponseValidation() {
		
		baseURI ="http://localhost";
		port= 8084;
		Response resp = when().get(EndPoints.getAllProject);
		
		// get 0th index projectId
		
		String projecctId = resp.jsonPath().get("[0].projectId");
		System.out.println(projecctId);
		
		resp.then().assertThat().time(lessThan(2500L));
		
	}

}
