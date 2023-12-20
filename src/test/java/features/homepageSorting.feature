Feature: HomePage Sorting Feature

  @WEB @sorting-by-price-lth
  Scenario: User can sort items listed by price (low to high)
    Given User is on the login page
    And User inputs the username "standard_user"
    And User inputs the password "secret_sauce"
    And User clicks the login button
    And User sees list of item "Sauce Labs Bolt T-Shirt"
    When User clicks sorting button
    And User clicks the sorting by price (low to high)
    Then List of products is sorted by price (low to high)