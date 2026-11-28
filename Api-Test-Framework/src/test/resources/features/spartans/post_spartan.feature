Feature: Spartans
  As a user,
  I want to be able to create a new spartan,
  so the spartan information can be accessed for training.

  @defect
  Scenario Outline: [TC - 014] Successfully creates a new spartan
    Given I am on the sparta api for an id
    When I send over body:
    """
     {
    "id": 0,
    "firstName": "<firstName>",
    "lastName": "<lastName>",
    "university": "<university>",
    "degree": "<degree>",
    "course": {
      "id": 0,
      "name": "<courseName>",
      "stream": {
        "id": 0,
        "name": "<streamName>",
        "courses": []
      },
      "streamId": 0,
      "trainer": "<trainer>",
      "startDate": "<startDate>",
      "endDate": "<endDate>",
      "spartans": []
    },
    "courseId": 0,
    "graduated": <graduated>
  }
    """
    Then I should get status 201

    Examples:
      | firstName | lastName | university            | degree           | courseName | streamName  | trainer      | startDate                | endDate                  | graduated |
      | Amelia    | Thornton | University of Leeds   | Computer Science | Java SDET  | Engineering | Marcus Hale  | 2026-11-09T09:00:00.000Z | 2027-01-29T17:00:00.000Z | false     |
      | Liampaul  | Okafor   | University of Bristol | Mathematics      | C# Dev     | Engineering | Priya Nandra | 2026-09-07T09:00:00.000Z | 2026-11-27T17:00:00.000Z | false     |
      | Sophie    | Marshall | University of Glasgow | Physics          | Data Eng   | Data        | Tom Ellery   | 2026-03-02T09:00:00.000Z | 2026-05-22T17:00:00.000Z | true      |

    @defect
  Scenario Outline: [TC - 015] Create a spartan with an already existing id
      Given I am on the sparta api for an id
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
      Then I should get a 409

      Examples:
        | id | firstName | lastName | university                | degree             | courseId | courseName     | streamId | streamName  | trainer        | startDate                | endDate                  | graduated | status |
        | 1  | Ethan     | Brooks   | University of Manchester  | Software Eng       | 20       | Java SDET      | 1        | Engineering | Hannah Wells   | 2026-11-09T09:00:00.000Z | 2027-01-29T17:00:00.000Z | false     | 201    |
        | 2  | Maya      | Patel    | University of Warwick     | Economics          | 21       | Business Ana   | 2        | Business    | Daniel Reeve   | 2026-10-05T09:00:00.000Z | 2026-12-18T17:00:00.000Z | false     | 201    |
        | 3  | Oliver    | Kemp     | University of Sheffield   | Electrical Eng     | 22       | DevOps         | 1        | Engineering | Grace Holloway | 2026-06-01T09:00:00.000Z | 2026-08-21T17:00:00.000Z | true      | 201    |
        | 4  | Chloe     | Adeyemi  | University of Nottingham  | Statistics         | 23       | Data Analysis  | 3        | Data        | Ravi Menon     | 2026-04-13T09:00:00.000Z | 2026-07-03T17:00:00.000Z | true      | 201    |
        | 5  | Harry     | Lindqvist| University of Edinburgh   | Computer Science   | 24       | C# Dev         | 1        | Engineering | Hannah Wells   | 2027-01-11T09:00:00.000Z | 2027-04-02T17:00:00.000Z | false     | 201    |