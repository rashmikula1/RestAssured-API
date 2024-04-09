package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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

public class UserRoleProgramBatchMapStep extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	 Response response;
	
	@Given("User able to get Get Assigned Program Batches of All Users")
	public void user_able_to_get_get_assigned_program_batches_of_all_users() throws IOException {
		res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token);
	   
	}

	@When("user calls {string} with {string} http request for Program Batches")
	public void user_calls_with_http_request_for_program_batches(String resource, String method) {
	  
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
	 response =res.when().get(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("DELETE"))
			 response =res.when().delete(resourceAPI.getResource());
		
	}

	@Then("the API call got success with status code {int} for Program Batches")
	public void the_api_call_got_success_with_status_code_for_program_batches(int int1) {
	
		int int2= response.getStatusCode();
		assertEquals(int2,int1);
		
	}
	
	

	@Then("the API call got success with status code {int} for Program Batches for  UserId")
	public void the_api_call_got_success_with_status_code_for_program_batches_for_user_id(int int1) {
	    
		int int2= response.getStatusCode();
		assertEquals(int2,int1);
	}
	
	@Given("User builds request for Program Batches of user by UserId")
	public void user_builds_request_for_program_batches_of_user_by_user_id() throws IOException {
		res=given().spec(requestSpecification())
				.header("Authorization", "Bearer "+ SigninStep.token).pathParam("userId",UserStep.UserId);

	    
	}

	@Then("Delete All Programs\\/Batches assigned to the User By UserId ith satus code {int}")
	public void delete_all_programs_batches_assigned_to_the_user_by_user_id_ith_satus_code(int int1) {
	   
		int int2= response.getStatusCode();
		assertEquals(int2,int1);
	}

}
