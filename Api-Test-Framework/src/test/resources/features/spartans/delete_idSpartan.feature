Feature: Spartans
  As a user,
  I want to delete a Spartan,

  Scenario: [TC - 009] Deleting a non-existent spartan
    Given I am on the delete api
    When I enter an invalid id of a non-existent spartan
    Then I should get an error

  Scenario: [TC - 010] Successfully deleting a spartan
    Given I am on the delete api
    When I enter a valid id to delete
    Then I should get http code 200
