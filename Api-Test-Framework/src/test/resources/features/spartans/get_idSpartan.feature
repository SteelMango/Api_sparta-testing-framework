Feature: Spartans
  As a user,
  I want to be able to get spartan data,
  Based off given ID.

  Scenario: [TC - 011] Get Spartan information based off valid id
    Given I am on the spartan api
    When I enter a valid id
    Then I should see information about the id

    Scenario: [TC - 012] Get error message for invalid id
      Given I am on the spartan api
      When I enter an invalid id for the spartan api
      Then I should get an error about invalid id input

