package com.labcorp.apiActions;



import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Actions {
	
	private String BASEURL = "https://6143a99bc5b553001717d06a.mockapi.io/";
	private String BASEPath_CreateGetUser = "/testapi/v1/Users";
	Response createUserResponse ;
	Response getUserResponse;
	String requestPayload = "{\r\n"
			+ "        \"createdAt\": 1631825833,\r\n"
			+ "        \"employee_firstname\": \"TestData12345\",\r\n"
			+ "        \"employee_lastname\": \"TestData12345\",\r\n"
			+ "        \"employee_phonenumbe\": \"264-783-9453\",\r\n"
			+ "        \"ademployee_emaildress\": \"ademployee_emaildress 1\",\r\n"
			+ "        \"citemployee_addressy\": \"citemployee_addressy 1\",\r\n"
			+ "        \"stateemployee_dev_level\": \"stateemployee_dev_level 1\",\r\n"
			+ "        \"employee_gender\": \"employee_gender 1\",\r\n"
			+ "        \"employee_hire_date\": \"2025-10-31T16:35:45.426Z\",\r\n"
			+ "        \"employee_onleave\": true,\r\n"
			+ "        \"tech_stack\": [],\r\n"
			+ "        \"project\": []\r\n"
			+ "    }\r\n"
			+ "";
			
	
	public void createUser()
	{
		createUserResponse = RestAssured
			.given().log().all()
				.baseUri(BASEURL)
				.basePath(BASEPath_CreateGetUser)
				.contentType(ContentType.JSON)
				.body(requestPayload)
				.post().then().log().all().extract().response();
				
	}
	
	public void verifyCreateUserStatusCodeAs(int statusCode)
	{
		createUserResponse.then().assertThat().statusCode(statusCode);
	}
	
	public void verifyGetUserStatusCodeAs(int statusCode)
	{
		getUserResponse.then().assertThat().statusCode(statusCode);
	}

	public void getUser()
	{
		getUserResponse = RestAssured
			.given().log().all()
				.baseUri(BASEURL)
				.contentType(ContentType.JSON)
				.basePath(BASEPath_CreateGetUser)
				.get();
	}
	
	public void assertDetails() throws JsonMappingException, JsonProcessingException
	{
		Assert.assertEquals(createUserResponse.jsonPath().getString("employee_firstname"), "TestData12345");
		Assert.assertEquals(createUserResponse.jsonPath().getString("employee_lastname"), "TestData12345");
		Assert.assertEquals(createUserResponse.jsonPath().getString("employee_phonenumbe"), "264-783-9453");
		Assert.assertEquals(createUserResponse.jsonPath().getString("ademployee_emaildress"), "ademployee_emaildress 1");
		Assert.assertEquals(createUserResponse.jsonPath().getString("citemployee_addressy"), "citemployee_addressy 1");
		Assert.assertEquals(createUserResponse.jsonPath().getString("stateemployee_dev_level"), "stateemployee_dev_level 1");
		Assert.assertEquals(createUserResponse.jsonPath().getString("employee_gender"), "employee_gender 1");
		Assert.assertEquals(createUserResponse.jsonPath().getString("employee_hire_date"), "2025-10-31T16:35:45.426Z");
		Assert.assertEquals(createUserResponse.jsonPath().getString("employee_onleave"), "true");
	}
	
}
