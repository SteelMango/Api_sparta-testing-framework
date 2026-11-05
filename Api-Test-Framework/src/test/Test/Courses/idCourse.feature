Feature: Courses by ID
  As a user,
  I want to find courses by ID,
  so that I can find relevant information.

  Scenario: Using letters
    Given I am on the courses id api
    When  I enter letters
    Then I should get an error about invalid input

  Scenario: Using negative number
    Given I am on the courses id api
    When I enter a negative number in the query
    Then An error about negative numbers should appear

  Scenario: Using invalid character
    Given I am on the courses id api
    When  I enter an invalid character
    Then An error should appear

  Scenario: Find course with invalid ID
    Given I am on the courses id api
    When I enter an invalid id query
    Then I should get a http code 204

  Scenario: Find course with valid ID
    Given I am on the courses id api
    When I enter a valid id query
    Then I should get a http code 200