Feature: Create User 

@LABCORP_API_TEST_01	
Scenario: User should be able to fetch the details 
	Given a user details are retrieved 
	Then verify status code for user details
	
@LABCORP_API_TEST_02
Scenario: User should be able to create user 
	Given a user is created with given data 
	Then verify status code for created user
	Then verify newly created user is found in the list 