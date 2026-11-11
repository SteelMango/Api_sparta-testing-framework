# Sparta Global ASP.NET API Test Report - Written by Penelope Farquharson 

## Overview

## Endpoints in Scope

### Authentication
| Method | Path        | Description                                                 |
|--------|-------------|-------------------------------------------------------------|
| POST   | /Auth/login | Allows the user to login with a valid username and password |

### Courses
| Method | Path              | Description |
|--------|-------------------|-------------|
| GET    | /api.courses      |             |
| GET    | /api/courses/{id} |

### Spartans
| Method | Path | Description |
|--------|------|-------------|
| GET    |   /api/spartans   |             |
| POST   |    /api/spartans    |             |
| GET    |    /api/spartans/{id}   |             |
| DELETE |  /api/spartans/{id}     |             |
| PUT    |    /api/spartans/{id}   |             |

## User Stories (Gherkin)

### US1 - Get all Courses 
```java
Feature: Course
  As a user,
  I want to view courses,
  So that I can use the relevant information for training

  Scenario: [TC-03] Successfully Check courses
    Given I am on the courses api
    When I get code 200
    Then I should get all the information about the courses
```
### US2 - Get Courses by ID
```java
Feature: Courses by ID
  As a user,
  I want to find courses by ID,
  so that I can find relevant information.

  Scenario: [TC-04] Using letters
    Given I am on the courses id api
    When  I enter letters
    Then I should get an error about invalid input

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
```

### US3 - Authentication 
```java
Feature: Authentication
  As a user,
  I want to login into my account with the given details,
  So I can see and manage Spartan courses


  Scenario: [TC-01] Valid details allows login
    Given I am on the login endpoint
    When I enter valid username "sparta"
    And  I enter valid password "global"
    Then I get status code 200

    Scenario: [TC-02] Invalid details prevents login
      Given I am on the login endpoint
      When I enter invalid username "test"
      And  I enter invalid password "test"
      Then I should get an error for invalid login details

```

### US4 - Delete Spartan
```java
Feature: Spartans
  As a user,
  I want to delete a Spartan,

  Scenario: [TC - 009] Deleting a non-existent spartan
    Given I am on the delete api
    When I enter an invalid id of a non-existent spartan
    Then I should get an error

  Scenario: [TC - 010] Successfully deleting a spartan
    Given I am on the delete api
    When I enter a valid id
    Then I should get http code 200

```

### US5 - Get Specifc Spartans Information 
```java
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
      When I enter an invalid id
      Then I should get an error about invalid id input


```

### US6 - Get all Spartans Information
```java
Feature: Spartans
  As a user,
  I want to be able to get information about all the spartans

  Scenario: [TC - 013] Able to sucessfully get all spartan information
    Given I am on the spartan api
    When I press enter
    Then I should see all the spartan information

```

### US7 - Post Spartan Information 
```java
Feature: Spartans
  As a user,
  I want to be able to create a new spartan,
  so the spartan information can be accessed for training.

  Scenario Outline: [TC - 014] Successfully creates a new spartan
    Given I am on the spartan post api
    When I send over body:
    """
    {
        "id": <id>,
        "firstName": "<firstName>",
        "lastName": "<lastName>",
        "university": "<university>",
        "degree": "<degree>",
        "course": {
          "id": <courseId>,
          "name": "<courseName>",
          "stream": {
            "id": <streamId>,
            "name": "<streamName>",
            "courses": ["<courseName>"]
          },
          "streamId": <streamId>,
          "trainer": "<trainer>",
          "startDate": "<startDate>",
          "endDate": "<endDate>",
          "spartans": ["<firstName> <lastName>"]
        },
        "courseId": <courseId>,
        "graduated": <graduated>
      }
    """
    Then I should get status <status>

    Examples:
      | id | firstName | lastName  | university              | degree              | courseId | courseName  | streamId | streamName  | trainer      | startDate                | endDate                  | graduated | status |
      | 6  | Ava       | Thornton  | University of Leeds     | Computer Science    | 10       | Java SDET   | 3        | Engineering | Marcus Hale  | 2026-11-09T09:00:00.000Z | 2027-01-29T17:00:00.000Z | false     | 200    |
      | 7  | Liam      | Okafor    | University of Bristol   | Mathematics         | 11       | C# Dev      | 3        | Engineering | Priya Nandra | 2026-09-07T09:00:00.000Z | 2026-11-27T17:00:00.000Z | false     | 200    |
      | 8  | Sophie    | Marsh     | University of Glasgow   | Physics             | 12       | Data Eng    | 4        | Data        | Tom Ellery   | 2026-03-02T09:00:00.000Z | 2026-05-22T17:00:00.000Z | true      | 200    |

    Scenario Outline: [TC - 015] Create a spartan with an already existing id
      Given I am on the spartan post api
      When I send over body:
          """
    {
        "id": <id>,
        "firstName": "<firstName>",
        "lastName": "<lastName>",
        "university": "<university>",
        "degree": "<degree>",
        "course": {
          "id": <courseId>,
          "name": "<courseName>",
          "stream": {
            "id": <streamId>,
            "name": "<streamName>",
            "courses": ["<courseName>"]
          },
          "streamId": <streamId>,
          "trainer": "<trainer>",
          "startDate": "<startDate>",
          "endDate": "<endDate>",
          "spartans": ["<firstName> <lastName>"]
        },
        "courseId": <courseId>,
        "graduated": <graduated>
      }
    """
      Then I should get a <status>

      Examples:
        | id | firstName | lastName | university                | degree             | courseId | courseName     | streamId | streamName  | trainer        | startDate                | endDate                  | graduated | status |
        | 1  | Ethan     | Brooks   | University of Manchester  | Software Eng       | 20       | Java SDET      | 1        | Engineering | Hannah Wells   | 2026-11-09T09:00:00.000Z | 2027-01-29T17:00:00.000Z | false     | 201    |
        | 2  | Maya      | Patel    | University of Warwick     | Economics          | 21       | Business Ana   | 2        | Business    | Daniel Reeve   | 2026-10-05T09:00:00.000Z | 2026-12-18T17:00:00.000Z | false     | 201    |
        | 3  | Oliver    | Kemp     | University of Sheffield   | Electrical Eng     | 22       | DevOps         | 1        | Engineering | Grace Holloway | 2026-06-01T09:00:00.000Z | 2026-08-21T17:00:00.000Z | true      | 201    |
        | 4  | Chloe     | Adeyemi  | University of Nottingham  | Statistics         | 23       | Data Analysis  | 3        | Data        | Ravi Menon     | 2026-04-13T09:00:00.000Z | 2026-07-03T17:00:00.000Z | true      | 201    |
        | 5  | Harry     | Lindqvist| University of Edinburgh   | Computer Science   | 24       | C# Dev         | 1        | Engineering | Hannah Wells   | 2027-01-11T09:00:00.000Z | 2027-04-02T17:00:00.000Z | false     | 201    |
```


## Issues 
1. Refactor folder system
2. word issues

