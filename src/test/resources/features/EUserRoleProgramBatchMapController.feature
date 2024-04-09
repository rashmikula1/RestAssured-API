@tag
Feature: GET REQUEST Get Assigned Program/Batch(es) of All Users

  Background: 

  Scenario Outline: SignIn
    Given User able to login with fields from "<KeyOption>" with "<Sheetname>"
    When user calls "LoginAPI" with "POST" http request
    Then the API call got success with status code 200

    Examples: 
      | KeyOption | Sheetname |
      | valid     | login     |

  @tag1 @UserRoleProgram @regression
  Scenario: Get Assigned Program/Batch(es) of All Users
    Given User able to get Get Assigned Program Batches of All Users
    When user calls "GetAssignedProgramBatchesofAllUsersAPI" with "GET" http request for Program Batches
    Then the API call got success with status code 200 for Program Batches

  @tag2 @UserRoleProgram @regression
  Scenario: Get Assigned Program/Batch of a User By User Id
    Given User builds request for Program Batches of user by UserId
    When user calls "GetAssignedProgramBatchofUserByUserIdAPI" with "GET" http request for Program Batches
    Then the API call got success with status code 200 for Program Batches for  UserId

  @tag3 @UserRoleProgram @regression
  Scenario: Delete All Programs/Batches assigned to the User By UserId
    Given User builds request for Program Batches of user by UserId
    When user calls "DeleteAllProgramsBatchesassignedtotheUserByUserIdAPI" with "DELETE" http request for Program Batches
    Then Delete All Programs/Batches assigned to the User By UserId ith satus code 200
