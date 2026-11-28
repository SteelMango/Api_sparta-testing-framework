Feature: Courses by ID
  As a user,
  I want to find courses by ID,
  so that I can find relevant information.

  Scenario: [TC-04] Using letters
    Given I am on the courses id api
    When  I enter letters
    Then I should get an error about invalid input

  @defect
  Scenario: [TC-05] Using negative number
    Given I am on the courses id api
    When I enter a negative number in the query
    Then An error about negative numbers should appear

  Scenario: [TC-06] Using invalid character
    Given I am on the courses id api
    When  I enter an invalid character
    Then An error should appear

  Scenario: [TC-07] Find course with invalid ID
    Given I am on the courses id api
    When I enter an invalid id query
    Then I should get a http code 204

  Scenario: [TC-08] Find course with valid ID
    Given I am on the courses id api
    When I enter a valid id query
    Then I should get a http code 200