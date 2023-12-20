Feature: Checkout

  @WEB @checkout-positive
  Scenario: User checks out item
    Given User is on the login page
    And User inputs the username "standard_user"
    And User inputs the password "secret_sauce"
    And User clicks the login button
    And User sees list of item "Sauce Labs Bolt T-Shirt"
    When User adds an item to the cart
    And Cart number change according to the item added
    And User clicks the cart icon
    And User proceeds to checkout
    And User fills in the first name "Nana"
    And User fills in the last name "Nina"
    And User fills in the zip code "17865"
    And User clicks continue button
    And User clicks finish button
    Then Order is successfully made with message "Thank you for your order!"