
Feature: Deletion
 Background: 

  Scenario Outline: SignIn
    Given User able to login with fields from "<KeyOption>" with "<Sheetname>"
    When user calls "LoginAPI" with "POST" http request
    Then the API call got success with status code 200

    Examples: 
      | KeyOption | Sheetname |
      | valid     | login     |
      
       @tag1 @regression
  Scenario: Delete user
  Given User builds request specfication for users with userid
  When user sends "DeleteUserAPI" with "DELETE" http request for user
  Then the user DELETED  with status code 200 displays
  
    @tag2 @regression
  Scenario: Delete existing Batch
  Given User needs build request for batch with batch id
  When user sends "DeleteexistingBatchAPI" with "DELETE" http request for batch
  Then the batch DELETED  with status code 200 displays
  
  @tag3 @regression
  Scenario: Delete Program by Program Name
  Given User builds request for program Name
  When user sends "DeleteProgramByProgramNameAPI" with "DELETE" http request for program
  Then the program with id DELETED  with status code 200
  
  

@tag4 @regression
  Scenario: Delete Program by Program ID

   Given User builds request for program id
  When user sends "DeleteProgramByProgramIDAPI" with "DELETE" http request for program
  Then the program with name DELETED  with status code 200
  
 
  
 
  
  
  