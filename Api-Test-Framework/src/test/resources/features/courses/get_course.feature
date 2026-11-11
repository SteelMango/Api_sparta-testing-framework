Feature: Course
  As a user,
  I want to view courses,
  So that I can use the relevant information for training

  Scenario: [TC-03] Successfully Check courses
    Given I am on the courses api
    When I get code 200
    Then I should get all the information about the courses

