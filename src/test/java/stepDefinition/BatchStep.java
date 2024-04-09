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
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.BatchPayload;
import payload.ProgramPayload;
import pojo.Batch;
import pojo.Program;
import response.BatchResponse;
import response.ProgramResponse;

public class BatchStep extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	 Response response;
	 public static  String BatchName;
	 public static int BatchId;
	
	 BatchPayload cr=new BatchPayload();
@Given("User needs to create a POST with from valid with batch for batch")
public void user_needs_to_create_a_post_with_from_valid_with_batch_for_batch() throws IOException, Exception {
	
	res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
			.body(cr.CreateBatch("valid","batch"));
}

@When("user sends {string} with {string} http request for batch")
public void user_sends_with_http_request_for_batch(String resource, String method) {
	
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
	response.then().log().all();
	
}

@Then("the batch get created with status code {int}")
public void the_batch_get_created_with_status_code(int int1) throws JsonMappingException, JsonProcessingException {
	response.then().log().all();
	
	int int2= response.getStatusCode();
	assertEquals(int2,int1);
	String responseBody= response.body().asString();
	
	      ObjectMapper objectMapper = new ObjectMapper();
        
            JsonNode jsonNode = objectMapper.readTree(responseBody);
           BatchName = jsonNode.get("batchName").asText();
            System.out.println("Batch Name: " + BatchName);
            BatchId = jsonNode.get("batchId").asInt();
            System.out.println("Batch ID: " + BatchId);
            
	
   
}

@Given("User needs to create a POST with from {string} with {string} for batch")
public void user_needs_to_create_a_post_with_from_with_for_batch(String KeyOption, String Sheetname) throws IOException, Exception {
	res=given().spec(requestSpecification())
			.header("Authorization", "Bearer "+ SigninStep.token)
			.body(cr.CreateBatch(KeyOption,Sheetname));
}

@Then("the batch get created from {string} with {int} and {string}")
public void the_batch_get_created_from_with_and(String KeyOption,  Integer int1, String message) throws JsonMappingException, JsonProcessingException {
	System.out.println("Keyoption  :"+ KeyOption);
	
	
	
		switch(KeyOption)
	{
	
case "valid":
	
   response.then().log().all().assertThat().statusCode(int1)
		.contentType(ContentType.JSON);
     /*   .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
              .getClassLoader()
              .getResourceAsStream("BatchPost200response.json")));*/
		BatchResponse pResponse= response.getBody().as(BatchResponse.class);
		assertEquals(pResponse.batchDescription, Batch.batchDescription);
		assertEquals(pResponse.batchName, Batch.batchName);
		assertEquals(pResponse.batchNoOfClasses, Batch.batchNoOfClasses);
		assertEquals(pResponse.batchStatus, Batch.batchStatus);
		
		BatchId= pResponse.batchId;
		BatchName=pResponse.batchName;
		System.out.println("Batch Id   :"+BatchId);
		System.out.println("Batch Name   :"+BatchName);
		
		break;
		
case "Existing":
	response.then().log().all().assertThat().statusCode(int1);
	String expectedResponseMessage = "Program "+ProgramStep.ProgramName +" with Batch-"+BatchStep.BatchName+" already exists: ; Please give a different batch Name or Choose a different Program";
	assertEquals(expectedResponseMessage, response.jsonPath().getString("message"));
	
	break;
	
case "Invalidstatus":	
case "Invalidname":
	response.then().log().all().assertThat().statusCode(int1);
	
    assertEquals(message, response.jsonPath().getString("message"));
	break;
case "Invalidclass":
	response.then().log().all().assertThat().statusCode(int1);
	String message1= " "+message+" ";
    assertEquals(message1, response.jsonPath().getString("message"));
	break;
	
	default:
		assertTrue(false);
		break;
	}
    
	
}

@Given("User needs build request for batch")
public void user_needs_build_request_for_batch() throws IOException, Exception {
	res=given().spec(requestSpecification())
			.header("Authorization", "Bearer "+ SigninStep.token);
	
    
	
}

@Then("all the batch displays with status code {int}")
public void all_the_batch_displays_with_status_code(int int1) {
	int int2= response.getStatusCode();
	assertEquals(int2,int1);
	
	
}

@Given("User needs build request for batch with batch id")
public void user_needs_build_request_for_batch_with_batch_id() throws IOException {
	
	System.out.println("Batch ID  :"+BatchId);
	res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
			.pathParams("batchId",BatchId);


}

@Then("the batch display with status code {int}")
public void the_batch_display_with_status_code(Integer int1) {
    
	Integer int2= response.getStatusCode();
	assertEquals(int2,int1);
	
	response.then().log().all().assertThat().statusCode(int1)
	.contentType(ContentType.JSON)
    .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
          .getClassLoader()
          .getResourceAsStream("BatchGetName200.json")));
}

@Given("User needs build request for batch with batch name")
public void user_needs_build_request_for_batch_with_batch_name() throws IOException {
	System.out.println("Batch NAme  :"+BatchName);
	res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
			.pathParams("batchName",BatchName);

    
}

@Given("User needs build request for batch by programid")
public void user_needs_build_request_for_batch_by_programid() throws IOException {
    
	res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
			.pathParam("programId",ProgramStep.ProgramId);

}

@Then("Batch details by Program Id displays with status code {int}")
public void batch_details_by_program_id_displays_with_status_code(int int1) {
   
	int int2= response.getStatusCode();
	assertEquals(int2,int1);
	response.then().log().all().assertThat().statusCode(int1)
	.contentType(ContentType.JSON)
    .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
          .getClassLoader()
          .getResourceAsStream("BatchProgramGet200.json")));
}

@Given("User needs to update the batch with from valid with batchput for batch")
public void user_needs_to_update_the_batch_with_from_valid_with_batchput_for_batch() throws Exception {
	res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
			.pathParam("batchId",BatchStep.BatchId).body(cr.UpdateBatch("valid","batchput"));
	
    
}

@Then("the batch get updated with status code {int}")
public void the_batch_get_updated_with_status_code(int int1) {
    
	int int2= response.getStatusCode();
	assertEquals(int1,int2);
}

@Given("User needs to update the batch with from {string} with {string} for batch")
public void user_needs_to_update_the_batch_with_from_with_for_batch(String string, String string2) throws IOException, Exception {
   
	res=given().spec(requestSpecification()).header("Authorization", "Bearer "+ SigninStep.token)
			.pathParam("batchId",BatchStep.BatchId)
			.body(cr.UpdateBatch(string,string2));
}

@Then("the batch get updated from {string} with {int} and {string}")
public void the_batch_get_updated_from_with_and(String KeyOption, Integer int1, String message) {

	switch(KeyOption)
{

case "valid":

response.then().log().all().assertThat().statusCode(int1)
	.contentType(ContentType.JSON)
    .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
          .getClassLoader()
          .getResourceAsStream("BatchPut200.json")));
	BatchResponse pResponse= response.getBody().as(BatchResponse.class);
	//assertEquals(pResponse.batchDescription, Batch.batchDescription);
	assertEquals(pResponse.batchName, Batch.batchName);
	assertEquals(pResponse.batchNoOfClasses, Batch.batchNoOfClasses);
	assertEquals(pResponse.batchStatus, Batch.batchStatus);
	
	
	
	break;
	
case "invalidstatus":
response.then().log().all().assertThat().statusCode(int1);

assertEquals(message, response.jsonPath().getString("message"));

break;

	
case "invaliddescription":
//response.then().log().all().assertThat().statusCode(int1);

//assertEquals(message, response.jsonPath().getString("message"));
break;
case "invalidclass":
response.then().log().all().assertThat().statusCode(int1);
String message1= " "+message+" ";
assertEquals(message1, response.jsonPath().getString("message"));
break;

default:
	assertTrue(false);
	break;
}

	
}



@Then("the batch DELETED  with status code {int} displays")
public void the_batch_deleted_with_status_code_displays(int int1) {
    
	int int2= response.getStatusCode();
	assertEquals(int2,int1);
}

}
