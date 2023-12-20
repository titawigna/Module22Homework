Feature: API Testing


  @API
  Scenario: Verify to GET list users data
    Given Prepare url for "GET_LIST_USERS"
    And Hit the GET API
    Then Validate status code is 200
    And Validate response body GET list users data
    And Validate response JSON with JSONSchema "get_list_user_normal.json"

  @API
  Scenario: Verify to POST new user
    Given Prepare url for "POST_NEW_USER"
    And Hit the POST API
    Then Validate status code is 201
    And Validate response body POST user data
    And Validate response JSON with JSONSchema "post_new_user_normal.json"

  @API
  Scenario: Verify to DELETE a user
    Given Prepare url for "POST_NEW_USER"
    And Hit the POST API
    Then Validate status code is 201
    And Validate response body POST user data
    And Hit the DELETE API
    And Validate status code is 204

  @API
  Scenario: Verify to UPDATE a user
    Given Prepare url for "POST_NEW_USER"
    And Hit the POST API
    Then Validate status code is 201
    And Validate response body POST user data
    And Hit the UPDATE API
    And Validate status code is 200
    And Validate response body UPDATE user data


