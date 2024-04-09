@tag
Feature: GET REQUEST (User Sign Out)

  Background: 

  Scenario Outline: SignIn
    Given User able to login with fields from "<KeyOption>" with "<Sheetname>"
    When user calls "LoginAPI" with "POST" http request
    Then the API call got success with status code 200

    Examples: 
      | KeyOption | Sheetname |
      | valid     | login     |

  @tag1 @signout @regression
  Scenario: SignOut
    Given User able to logout
    When user calls "LogoutAPI" with "GET" http request for logout
    Then the user logs out successfully with status code 200
