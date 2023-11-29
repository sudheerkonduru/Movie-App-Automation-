Feature: Test the counter functionality

  Scenario: Successful counting
    Given I am on given url
    When  I click on Clickme button
    Then I should be get same count as how much i click
