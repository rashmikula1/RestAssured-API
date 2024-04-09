package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import payload.ProgramPayload;
import payload.SignInPayload;
import response.ProgramResponse;
import pojo.Program;

import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ProgramStep extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	 Response response;
	 public static  String ProgramName;
	 public static int ProgramId;
	 ProgramPayload cr=new ProgramPayload();
	
	 @Given("User needs to create a POST with from {string} with {string}")
	 public void user_needs_to_create_a_post_with_from_with(String KeyOption, String Sheetname) throws IOException, Exception {
	     
			res=given().spec(requestSpecification())
					.header("Authorization", "Bearer "+ SigninStep.token).body(cr.CreateProgram(KeyOption,Sheetname));

	 }
	
	

	@When("user sends {string} with {string} http request for program")
	public void user_sends_with_http_request_for_logout(String resource, String method) {

		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
	 response =res.when().get(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("DELETE"))
			 response =res.when().delete(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("PUT"))
			 response =res.when().put(resourceAPI.getResource());
		
	    
	}

	
	
	
	
			
			
			
		
	
	@Then("the users receives data from {string} with {string} and program get created with status code {int} and {string}")
	public void the_users_receives_data_from_with_and_program_get_created_with_status_code_and(String KeyOption, String Sheetname, int int1, String expectedResponseMessage) {
	    
		
		switch(KeyOption)
		{
		
	case "valid":
		response.then().log().all().assertThat().statusCode(int1)
			.contentType(ContentType.JSON)
	        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
	              .getClassLoader()
	              .getResourceAsStream("ProgramPost200.json")));
			ProgramResponse pResponse= response.getBody().as(ProgramResponse.class);
			assertEquals(pResponse.programDescription, Program.programDescription);
			assertEquals(pResponse.programName, Program.programName);
			assertEquals(pResponse.programStatus, Program.programStatus);
			ProgramId= pResponse.programId;
			ProgramName=pResponse.programName;
			System.out.println("Program Id   :"+ProgramId);
			System.out.println("Program Name   :"+ProgramName);
			break;
			
	case "Existing":
	case "invalidprogramstatus":	
	case "invalidprogramname":
		response.then().log().all().assertThat().statusCode(int1);
        assertEquals(expectedResponseMessage, response.jsonPath().getString("message"));
		break;
		
		default:
			assertTrue(false);
			break;
		}
			
	}
	
	
	@Given("User builds request for all program")
	public void user_builds_request_for_all_program() throws IOException {
		res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token);

		
		
	}

	@Then("all the program displays with status code {int}")
	public void all_the_program_displays_with_status_code(int int1) {
	   
		
		
		response.then().log().all().assertThat().statusCode(int1)
		.contentType(ContentType.JSON)
        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
              .getClassLoader()
              .getResourceAsStream("ProgramGet200.json")));
	}
	
	@Then("all the program along with the users displays with status code {int}")
	public void all_the_program_along_with_the_users_displays_with_status_code(int int1) {
	    
		int int2= response.getStatusCode();
		assertEquals(int2,int1);

		/*response.then().log().all().assertThat().statusCode(int1)
		.contentType(ContentType.JSON)
        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
              .getClassLoader()
              .getResourceAsStream("ProgramUserGet200.json")));*/
	}
	
	@Given("User builds request for program id")
	public void user_builds_request_for_program_id() throws IOException {
		
		res=given().spec(requestSpecification())
				.header("Authorization", "Bearer "+ SigninStep.token)
				.pathParam("programId",ProgramId);

	}

	@Then("the program deatils displays for the programid  with status code {int}")
	public void the_program_deatils_displays_for_the_programid_with_status_code(int int1) {
	   
		
		response.then().log().all().assertThat().statusCode(int1)
		.contentType(ContentType.JSON)
        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
              .getClassLoader()
              .getResourceAsStream("ProgramIDGet200.json")));
	}
	@Then("the program with id DELETED  with status code {int}")
	public void the_program_deleted_with_the_programid_with_status_code(int int1) {
		int int2= response.getStatusCode();
		assertEquals(int2,int1);
		
		String expectedResponseMessage = "Program Id-" + ProgramId + " is deleted Successfully!";
		assertEquals(expectedResponseMessage, response.jsonPath().getString("message"));

	}
	
	@Then("the program with name DELETED  with status code {int}")
	public void the_program_deleted_with_the_programname_with_status_code(int int1) {
		int int2= response.getStatusCode();
		assertEquals(int2,int1);
		
		String expectedResponseMessage = "Program Id-" + ProgramId + " is deleted Successfully!";
		assertEquals(expectedResponseMessage, response.jsonPath().getString("message"));

	}
	@Given("User builds request for program Name")
	public void user_builds_request_for_program_name() throws IOException {
		res=given().spec(requestSpecification())
				.header("Authorization", "Bearer "+ SigninStep.token)
				.pathParam("programName",ProgramName);
 
	}
	

@Given("User builds request for program name with fields from valid with programput")
public void user_builds_request_for_program_name_with_fields_from_valid_with_programput() throws Exception {
	res=given().spec(requestSpecification())
			.header("Authorization", "Bearer "+ SigninStep.token)
			.pathParam("programName",ProgramName)
			.body(cr.UpdateProgram("valid","programput"));

}

@Given("User builds request for program id with fields from valid with programput")
public void user_builds_request_for_program_id_with_fields_from_valid_with_programput() throws Exception {
   
	res=given().spec(requestSpecification())
			.header("Authorization", "Bearer "+ SigninStep.token)
			.pathParam("programId",ProgramId)
			.body(cr.UpdateProgram("valid","programput"));

}



@Given("User builds request for program id with fields from {string} with {string}")
public void user_builds_request_for_program_id_with_fields_from_with(String KeyOption, String Sheetname) throws IOException, Exception {
    
	res=given().spec(requestSpecification())
			.header("Authorization", "Bearer "+ SigninStep.token)
			.pathParam("programId",ProgramId)
			.body(cr.UpdateProgram(KeyOption,Sheetname));

}

@Then("the program updated from {string}  with {int} and {string}")
public void the_program_updated_from_with_and(String KeyOption, Integer int1, String message) {
    
	  
			switch(KeyOption)
			{
			
		case "valid":
			response.then().log().all().assertThat().statusCode(int1)
				.contentType(ContentType.JSON)
		        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
		              .getClassLoader()
		              .getResourceAsStream("ProgramPut200.json")));
				ProgramResponse pResponse= response.getBody().as(ProgramResponse.class);
				assertEquals(pResponse.programDescription, Program.programDescription);
				assertEquals(pResponse.programName, Program.programName);
				assertEquals(pResponse.programStatus, Program.programStatus);
				
				break;
				
		
		case "invaliddescription":	
		case "invalidstatus":
			response.then().log().all().assertThat().statusCode(int1);
	        assertEquals(message, response.jsonPath().getString("message"));

			break;
			
			default:
				assertTrue(false);
				break;
			}
	
	
}

@Given("User builds request for program name with fields from {string} with {string}")
public void user_builds_request_for_program_name_with_fields_from_with(String KeyOption, String Sheetname) throws IOException, Exception {
   
	res=given().spec(requestSpecification())
			.header("Authorization", "Bearer "+ SigninStep.token)
			.pathParam("programName",ProgramName).body(cr.UpdateProgram(KeyOption,Sheetname));

}



}
