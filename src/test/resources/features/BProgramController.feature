@tag
Feature: POST (Create New Program)

  Background: 

  Scenario Outline: SignIn
    Given User able to login with fields from "<KeyOption>" with "<Sheetname>"
    When user calls "LoginAPI" with "POST" http request
    Then the API call got success with status code 200

    Examples: 
      | KeyOption | Sheetname |
      | valid     | login     |

  @tag1 @program @regresiion
  Scenario Outline: POST (Create New Program)
    Given User needs to create a POST with from "<KeyOption>" with "<Sheetname>"
    When user sends "CreateProgramAPI" with "POST" http request for program
    Then the users receives data from "<KeyOption>" with "<Sheetname>" and program get created with status code <status> and "<message>"

    Examples: 
      | KeyOption            | Sheetname | status | message                                                                           |
      | valid                | program   |    201 | created                                                                           |
      | Existing             | program   |    400 | cannot create program , since already exists                                      |
      | invalidprogramname   | program   |    400 | programName must begin with alphabet and can contain only alphanumeric characters |
      | invalidprogramstatus | program   |    400 | Invalid Status: must be Active or Inactive                                        |

  @tag2  @program @regresiion
  Scenario: Get all Programs
    Given User builds request for all program
    When user sends "GetAllProgramAPI" with "GET" http request for program
    Then all the program displays with status code 200

  @tag3  @program @regresiion
  Scenario: Get all Programs along with users in each program
    Given User builds request for all program
    When user sends "GellAllProgramWithUserAPI" with "GET" http request for program
    Then all the program along with the users displays with status code 200

  @tag4  @program @regresiion
  Scenario: Get Program by Program ID
    Given User builds request for program id
    When user sends "GetProgrambyProgramID" with "GET" http request for program
    Then the program deatils displays for the programid  with status code 200

  @tag5  @program @regresiion
  Scenario Outline: Update Program by Program id
    Given User builds request for program id with fields from "<KeyOption>" with "<Sheetname>"
    When user sends "UpdateProgrambyProgramIDAPI" with "PUT" http request for program
    Then the program updated from "<KeyOption>"  with <statuscode> and "<message>"

    Examples: 
      | KeyOption          | Sheetname  | statuscode | message                                                                                  |
      | valid              | programput |        200 | updated                                                                                  |
      | invaliddescription | programput |        400 | programDescription must begin with alphabet and can contain only alphanumeric characters |
      | invalidstatus      | programput |        400 | Invalid Status: must be Active or Inactive                                               |

  @tag6  @program @regresiion
  Scenario Outline: Update Program by Program Name
    Given User builds request for program name with fields from "<KeyOption>" with "<Sheetname>"
    When user sends "UpdateProgramByProgramNameAPI" with "PUT" http request for program
    Then the program updated from "<KeyOption>"  with <statuscode> and "<message>"

    Examples: 
      | KeyOption          | Sheetname  | statuscode | message                                                                                  |
      | valid              | programput |        200 | updated                                                                                  |
      | invaliddescription | programput |        400 | programDescription must begin with alphabet and can contain only alphanumeric characters |
      | invalidstatus      | programput |        400 | Invalid Status: must be Active or Inactive                                               |
   