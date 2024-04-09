
@tag
Feature: POST REQUEST (User Sign In)
  

  @tag1 @regression @signin
  Scenario Outline: SignIn 
    Given User able to login with fields from "<KeyOption>" with "<Sheetname>"
    When user calls "LoginAPI" with "POST" http request
    Then the API call got success with status code 200
    Examples: 
      | KeyOption | Sheetname |
       | valid| login   |
       
      
    
    
   


