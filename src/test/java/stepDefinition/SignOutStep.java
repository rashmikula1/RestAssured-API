package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import dataProvider.Utils;

import endpoints.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.junit.Assert.*;

public class SignOutStep extends Utils {
	public static RequestSpecification res;
	Response response;
	ResponseSpecification resspec;
	@Given("User able to logout")
	public void user_able_to_logout() throws IOException {
		
		res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token);;
	    
	}
	
	@When("user calls {string} with {string} http request for logout")
	public void user_calls_with_http_request_for_logout(String resource, String method) {
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		 if(method.equalsIgnoreCase("GET"))
	 response =res.when().get(resourceAPI.getResource());
	}

	@Then("the user logs out successfully with status code {int}")
	public void the_user_logs_out_successfully_with_status_code(int int1) {
	
      response.then().log().all();
		
		int int2= response.getStatusCode();
		assertEquals(int2,int1);
		
	}

}
