package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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

import payload.UserPayload;

public class UserStep extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	 Response response;
	 public static  String UserName;
	 public static String UserId;
	 UserPayload cr=new UserPayload();
	 
	
	@Given("User needs to create a POST with from {string} with {string} for user")
	public void user_needs_to_create_a_post_with_from_with_for_user(String KeyOption, String Sheetname) throws IOException, Exception {
		res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
				.body(cr.CreateUser(KeyOption,Sheetname));
	}

	@When("user sends {string} with {string} http request for user")
	public void user_sends_with_http_request_for_user(String resource, String method) {
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec =new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
	 response =res.when().get(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("PUT"))
			 response =res.when().put(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("DELETE"))
			 response =res.when().delete(resourceAPI.getResource());
		response.then().log().all();
		
	}

	@Then("the user get created with status code {int}")
	public void the_user_get_created_with_status_code(int int1) throws JsonMappingException, JsonProcessingException {
	   
		int int2= response.getStatusCode();
		
		assertEquals(int2,int1);
		String responseBody= response.body().asString();
		
		      ObjectMapper objectMapper = new ObjectMapper();
	        
	            JsonNode jsonNode = objectMapper.readTree(responseBody);
	           UserName = jsonNode.get("userFirstName").asText();
	            System.out.println("User Name: " + UserName);
	            UserId = jsonNode.get("userId").asText();
	            System.out.println("User ID: " + UserId);
		
	}
	

	

	@Given("User needs to create a PUT with from {string} with {string} for update user program batch status")
	public void user_needs_to_create_a_put_with_from_with_for_update_user_program_batch_status(String KeyOption, String Sheetname) throws IOException, Exception {
		res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
				.body(cr.updatebatchstatus(KeyOption,Sheetname))
				.pathParam("userId",UserId);
	}
	

	@Then("the user Role Program Batch status get updated with status code {int}")
	public void the_user_get_updated_with_status_code(int int1) {
	   
int int2= response.getStatusCode();
		
		assertEquals(int2,int1);
	}

	
	
	@Given("User needs to create a PUT with from {string} with {string} for update user")
	public void user_needs_to_create_a_put_with_from_with_for_update_user(String KeyOption, String Sheetname) throws IOException, Exception {
	    
		res=given().spec(requestSpecification())
				.header("Authorization", "Bearer "+ SigninStep.token)
				.body(cr.Updateuser(KeyOption,Sheetname))
				.pathParam("userId",UserId);
	}

	@Then("the user get updated with status code {int}")
	public void the_user_get_updated_with_status_code1(int int1) {
     int int2= response.getStatusCode();
		
		assertEquals(int2,int1);
	    
		
	}
	
	
	@Given("User needs to create a PUT with from {string} with {string} for update user role status")
	public void user_needs_to_create_a_put_with_from_with_for_update_user_role_status(String KeyOption, String Sheetname) throws IOException, Exception {
	   
		res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
				.body(cr.update(KeyOption,Sheetname))
				.pathParam("userId",UserId);
	}


	@Then("the user get updated role status with status code {int}")
	public void the_user_get_updated_role_status_with_status_code(int int1) {
int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
		
	}
	
	@Given("User needs to create a PUT with from <KeyOption> with <Sheetname> for update user role ID")
	public void user_needs_to_create_a_put_with_from_key_option_with_sheetname_for_update_user_role_id() throws IOException, Exception {
		res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
				.body(cr.UpdateUserRoleId("valid","putUser"))
				.pathParam("userId",UserId);
		
	}
	@Given("User needs to create a PUT with from {string} with {string} for update user role ID")
	public void user_needs_to_create_a_put_with_from_with_for_update_user_role_id(String KeyOption, String Sheetname) throws IOException, Exception {
	    
		res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
				.body(cr.UpdateUserRoleId(KeyOption,Sheetname))
				.pathParam("userId",UserId);
	}
	
	
	

	@Then("the user role id get updated role status with status code {int}")
	public void the_user_role_id_get_updated_role_status_with_status_code(int int1) {
	   
int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
	}
	
	
		
		
	
	@Given("User needs to create a PUT with from {string} with {string} for update user loginstatus")
	public void user_needs_to_create_a_put_with_from_with_for_update_user_loginstatus(String KeyOption, String Sheetname) throws IOException, Exception {
		res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
				.body(cr.UpdateUserLogin(KeyOption,Sheetname))
				.pathParam("userId",UserId);
	}

	@Then("the user login status get updated role status with status code {int}")
	public void the_user_login_status_get_updated_role_status_with_status_code(int int1) {
	   
int int2= response.getStatusCode();
		
		assertEquals(int2,int1);
		
	}
	
	@Given("User builds request specfication for users")
	public void user_builds_request_specfication_for_users() throws IOException, Exception {
		res=given().spec(requestSpecification())
				.header("Authorization", "Bearer "+ SigninStep.token);
				
	
	    
	}

	@Then("all roles displayed with status code {int}")
	public void all_roles_displayed_with_status_code(int int1) {
		
int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
	    
	}

	@Then("all users displayed with status code {int}")
	public void all_users_displayed_with_status_code(int int1) {
int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
		
		
	}
	
	@Then("all active users displayed with status code {int}")
	public void all_active_users_displayed_with_status_code(int int1) {
int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
	}

	@Then("count of active and inactive users displayed with status code {int}")
	public void count_of_active_and_inactive_users_displayed_with_status_code(int int1) {
int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
	}

	@Then("all  users with roles displayed with status code {int}")
	public void all_users_with_roles_displayed_with_status_code(int int1) {
int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
	}

	@Then("all  users with filters displayed with status code {int}")
	public void all_users_with_filters_displayed_with_status_code(int int1) {
int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
	}
	
	@Given("User builds request specfication for users with userid")
	public void user_builds_request_specfication_for_users_with_userid() throws IOException {
	   
		res=given().spec(requestSpecification())
				.header("Authorization", "Bearer "+ SigninStep.token)
				.pathParam("userId",UserId);
	}

	@Then("all the  users info by id displayed with status code {int}")
	public void all_the_users_info_by_id_displayed_with_status_code(int int1) {
	    
     int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
	}

	@Given("User builds request specfication for users with batchid")
	public void user_builds_request_specfication_for_users_with_batchid() throws IOException {
		res=given().spec(requestSpecification())
				.header("Authorization", "Bearer "+ SigninStep.token)
				.pathParam("batchId",BatchStep.BatchId);
		
	}

	@Then("all  users with program batches displayed with status code {int}")
	public void all_users_with_program_batches_displayed_with_status_code(int int1) {
      int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
		
	}

	@Given("User builds request specfication for users with proramid")
	public void user_builds_request_specfication_for_users_with_proramid() throws IOException {
		res=given().spec(requestSpecification())
				.header("Authorization", "Bearer "+ SigninStep.token)
				.pathParam("programId",ProgramStep.ProgramId);
		
	}

	@Then("all  users with program  displayed with status code {int}")
	public void all_users_with_program_displayed_with_status_code(int int1) {
    int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
		
	}

	
	@Given("User builds request specfication for users with {string}")
	public void user_builds_request_specfication_for_users_with(String roleid) throws IOException {
		res=given().spec(requestSpecification())
				.header("Authorization", "Bearer "+ SigninStep.token)
				.pathParam("roleId",roleid);
	}

	@Then("all  users with role id displayed with status code {int}")
	public void all_users_with_role_id_displayed_with_status_code(int int1) {
	    
   int int2= response.getStatusCode();
		
		assertEquals(int1,int2);
	}
	@Then("the user DELETED  with status code {int} displays")
	public void the_user_deleted_with_status_code_displays(int int1) {
	  
		int int2= response.getStatusCode();
		assertEquals(int2,int1);
	}















}
