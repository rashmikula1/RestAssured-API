package stepDefinition;

import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.SignInPayload;
import dataProvider.Utils;
import endpoints.APIResources;

import static org.junit.Assert.*;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class SigninStep extends Utils {
	 RequestSpecification res;
	ResponseSpecification resspec;
	 Response response;
	SignInPayload cr=new SignInPayload();
	public static String token;
	
	@Given("User able to login with fields from valid with login")
	public void user_able_to_login_with_fields_from_valid_with_login() throws IOException, Exception {
	   
		res=given().spec(requestSpecification()).body(cr.login("valid","login"));
		
		

	}
	@Given("User able to login with fields from {string} with {string}")
	public void user_able_to_login_with_fields_from_with(String KeyOption, String Sheetname) throws IOException, Exception {
		res=given().spec(requestSpecification()).body(cr.login(KeyOption,Sheetname));
	}

	

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		
		resspec =new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		 response =res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
	 response =res.when().post(resourceAPI.getResource());
		
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) throws JsonMappingException, JsonProcessingException {
        response.then().log().all();
		
		String responseBody= response.body().asString();
		
		 ObjectMapper objectMapper = new ObjectMapper();
	        
	            JsonNode jsonNode = objectMapper.readTree(responseBody);
	           token = jsonNode.get("token").asText();
	            System.out.println("Token: " + token);
	        
	    
	}


}
