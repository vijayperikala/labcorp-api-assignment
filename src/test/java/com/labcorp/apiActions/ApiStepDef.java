package com.labcorp.apiActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiStepDef {
	
	Actions action = new Actions();
	
	@Given("a user is created with given data")
	public void a_user_is_created_with_given_data() {
	    action.createUser();
	}

	@Then("verify status code for created user")
	public void verify_status_code() {
	    action.verifyCreateUserStatusCodeAs(201);
	}
	
	@Then("verify status code for user details")
	public void verify_status_code_for_user_details() {
		action.verifyGetUserStatusCodeAs(200);
	}

	@When("all user details are retrieved")
	public void all_user_details_are_retrieved() {
	    action.getUser();
	}

	@Then("verify newly created user is found in the list")
	public void verify_newly_created_user_is_found_in_the_list() throws JsonMappingException, JsonProcessingException {
	    action.assertDetails();
	}

	@Given("a user details are retrieved")
	public void a_user_details_are_retrieved() {
		 action.getUser();
	}
	
	
}
