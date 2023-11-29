Feature: Login Functionality
  As a user of the E-commerce Application
  I want to be able to login into my account
   So that i can access personalized features make purchases
  Scenario: Successful Login
    Given I am on loginpage
    When  I enter valid user name and password
    And  I click on login button
    Then I should be redirected to the homepage
