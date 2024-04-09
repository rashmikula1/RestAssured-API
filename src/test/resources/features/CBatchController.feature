@tag
Feature: POST (Create New Batch)

  Background: 

  Scenario Outline: SignIn
    Given User able to login with fields from <KeyOption> with <Sheetname>
    When user calls "LoginAPI" with "POST" http request
    Then the API call got success with status code 200

    Examples: 
      | KeyOption | Sheetname |
      | valid     | login     |

  @tag1  @batch @regresiion
  Scenario Outline: Create new batch
    Given User needs to create a POST with from "<KeyOption>" with "<Sheetname>" for batch
    When user sends "CreateNewBatchAPI" with "POST" http request for batch
    Then the batch get created from "<KeyOption>" with <status> and "<message>"

    Examples: 
      | KeyOption     | Sheetname | status | message                                                                         |
      | valid         | batch     |    201 | created                                                                         |
      | Existing      | batch     |    400 |                                                                                 |
      | Invalidname   | batch     |    400 | batchName must begin with alphabet and can contain only alphanumeric characters |
      | Invalidstatus | batch     |    400 | Invalid Status: must be Active or Inactive                                      |
      | Invalidclass  | batch     |    400 | No of Classes is needed; It should be a positive number                         |

  @tag2  @batch @regresiion
  Scenario: Get All Batches

   Given User needs build request for batch
   When user sends "GetAllBatchAPI" with "GET" http request for batch
   Then all the batch displays with status code 200
   
  @tag3  @batch @regresiion
  Scenario: Get Batches with batch id
    Given User needs build request for batch with batch id
    When user sends "GetBatchdetailsBatchIdAPI" with "GET" http request for batch
    Then the batch display with status code 200

  @tag4 @batch @regresiion
  Scenario: Get Batches with batch name
    Given User needs build request for batch with batch name
    When user sends "GetBatchdetailsbyBatchNameAPI" with "GET" http request for batch
    Then the batch display with status code 200

  @tag5 @batch @regresiion
  Scenario: Get Batch details by Program Id
    Given User needs build request for batch by programid
    When user sends "GetBatchdetailsbyProgramIdAPI" with "GET" http request for batch
    Then Batch details by Program Id displays with status code 200

  @tag6 @batch @regresiion
  Scenario Outline: Update batch
    Given User needs to update the batch with from "<KeyOption>" with "<Sheetname>" for batch
    When user sends "UpdateBatchdetailsAPI" with "PUT" http request for batch
    Then the batch get updated from "<KeyOption>" with <statuscode> and "<message>"

    Examples: 
      | KeyOption          | Sheetname | statuscode | message                                                                                |
      | valid              | batchput  |        200 | updated                                                                                |
      | invalidstatus      | batchput  |        400 | Invalid Status: must be Active or Inactive                                             |
      | invalidclass       | batchput  |        400 | No of Classes is needed; It should be a positive number                                |
      | invaliddescription | batchput  |        400 | batchDescription must begin with alphabet and can contain only alphanumeric characters |
