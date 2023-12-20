Feature: Login

  @WEB @login-valid
  Scenario: User login with valid email
    Given User is on the login page
    And User inputs the username "standard_user"
    And User inputs the password "secret_sauce"
    When User clicks the login button
    Then User is logged in