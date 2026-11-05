Feature: Authentication
  As a user,
  I want to login into my account with the given details,
  So I can see and manage Spartan courses


  Scenario: Valid details allows login
    Given I am on the login endpoint
    When I enter valid username "sparta"
    And  I enter valid password "global"
    Then I get status code 200

    Scenario: Invalid details prevents login
      Given I am on the login endpoint
      When I enter invalid username "test"
      And  I enter invalid password "test"
      Then I should get an error for invalid login details

