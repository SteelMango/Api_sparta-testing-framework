Feature: Spartans
  As a user,
  I want to be able to get information about all the spartans

  Scenario: [TC - 013] Able to sucessfully get all spartan information
    Given I am on the spartan api
    When I press enter
    Then I should see all the spartan information
