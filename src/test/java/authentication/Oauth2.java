package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 {
	
	@Test
	public void oAuth2()
	{
		Response resp = given().formParam("client_id", "SDET0")
		.formParam("client_secret", "6bcb35786c0565dd559a5b4347202d0c")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		
		.when().post("http://coop.apps.symfonycasts.com/token");
		
		String token=resp.jsonPath().get("access_token");
		
		System.out.println("Token is : "+token);
		
		given().auth().oauth2(token)
		.pathParam("USER_ID", "2296")
		
		.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then().log().all();
	}
}
