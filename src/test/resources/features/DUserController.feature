@tag
Feature: POST (Create New User)

  Background: 

  Scenario Outline: SignIn
    Given User able to login with fields from "<KeyOption>" with "<Sheetname>"
    When user calls "LoginAPI" with "POST" http request
    Then the API call got success with status code 200

    Examples: 
      | KeyOption | Sheetname |
      | valid     | login     |

  @tag1 @user @regresiion
  Scenario Outline: POST (Create New User) valid
    Given User needs to create a POST with from "<KeyOption>" with "<Sheetname>" for user
    When user sends "CreateUserLoginwithRoleAPI" with "POST" http request for user
    Then the user get created with status code 201

    Examples: 
      | KeyOption | Sheetname |
      | valid     | user      |

  @tag2 @user @regresiion
  Scenario Outline: PUT Update User Role Program Batch status
    Given User needs to create a PUT with from "<KeyOption>" with "<Sheetname>" for update user program batch status
    When user sends "UpdateUserRoleProgramBatchstatusAPI" with "PUT" http request for user
    Then the user Role Program Batch status get updated with status code 200

    Examples: 
      | KeyOption | Sheetname               |
      | valid     | putUserRoleProgramBatch |

  @tag3 @user @regresiion
  Scenario Outline: Update User
    Given User needs to create a PUT with from "<KeyOption>" with "<Sheetname>" for update user
    When user sends "UpdateUserAPI" with "PUT" http request for user
    Then the user get updated with status code 200

    Examples: 
      | KeyOption | Sheetname |
      | valid     | putUser   |

  @tag4 @user @regresiion
  Scenario Outline: Update User Role Status
    Given User needs to create a PUT with from "<KeyOption>" with "<Sheetname>" for update user role status
    When user sends "UpdateUserRoleStatusAPI" with "PUT" http request for user
    Then the user get updated role status with status code 200

    Examples: 
      | KeyOption | Sheetname         |
      | valid     | putUserRoleStatus |

  @tag5 @user @regresiion
  Scenario Outline: Update User Role Id
    Given User needs to create a PUT with from "<KeyOption>" with "<Sheetname>" for update user role ID
    When user sends "UpdateUserRoleIdAPI" with "PUT" http request for user
    Then the user role id get updated role status with status code 200

    Examples: 
      | KeyOption | Sheetname     |
      | valid     | PutUSerRoleId |

  @tag6 @user @regresiion
  Scenario Outline: Update User login status
    Given User needs to create a PUT with from "<KeyOption>" with "<Sheetname>" for update user loginstatus
    When user sends "UpdateUserLoginStatusAPI" with "PUT" http request for user
    Then the user login status get updated role status with status code 200

    Examples: 
      | KeyOption | Sheetname    |
      | valid     | PutUserLogin |
      

  @tag7 @user @regresiion
  Scenario: Get All roles
    Given User builds request specfication for users
    When user sends "GetAllrolesAPI" with "GET" http request for user
    Then all roles displayed with status code 200

  @tag8 @user @regresiion
  Scenario: Get All users
    Given User builds request specfication for users
    When user sends "GetallUsersAPI" with "GET" http request for user
    Then all users displayed with status code 200

  @tag9 @user @regresiion
  Scenario: Get All active users
    Given User builds request specfication for users
    When user sends "GetallActiveUserAPI" with "GET" http request for user
    Then all active users displayed with status code 200

  @tag10 @user @regresiion
  Scenario: Gets count of active and inactive users. Unless role id is specified, gets all type of users
    Given User builds request specfication for users
    When user sends "GetcountofactiveandinactiveUSerAPI" with "GET" http request for user
    Then count of active and inactive users displayed with status code 200

  @tag11 @user @regresiion
  Scenario: getAllUsersWithRoles
    Given User builds request specfication for users
    When user sends "GetAllUsersWithRolesAPI" with "GET" http request for user
    Then all  users with roles displayed with status code 200

  @tag12 @user @regresiion
  Scenario: Get all Users with Facets/Filters
    Given User builds request specfication for users
    When user sends "GetallUserswithFacetsFiltersAPI" with "GET" http request for user
    Then all  users with filters displayed with status code 200

  @tag13 @user @regresiion
  Scenario: Get User Information by ID
    Given User builds request specfication for users with userid
    When user sends "GetUserInfobyID" with "GET" http request for user
    Then all the  users info by id displayed with status code 200

  @tag14 @user @regresiion
  Scenario: get User by Program Batches
    Given User builds request specfication for users with batchid
    When user sends "GetUserbyProgramBatchesAPI" with "GET" http request for user
    Then all  users with program batches displayed with status code 200

  @tag15 @user @regresiion
  Scenario: Get User for Program
    Given User builds request specfication for users with proramid
    When user sends "GetUserforProgramAPI" with "GET" http request for user
    Then all  users with program  displayed with status code 200

  @tag16 @user @regresiion
  Scenario Outline: Get User by RoleID
    Given User builds request specfication for users with "<roleid>"
    When user sends "GetUserbyRoleIDAPI" with "GET" http request for user
    Then all  users with role id displayed with status code 200

    Examples: 
      | roleid |
      | R01    |
      | R02    |
      | R03    |
