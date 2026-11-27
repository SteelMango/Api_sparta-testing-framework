Feature: Spartans
  As an admin,
  I want to be able to update current spartan information,
  So the business is up to date with our employees contacts.

  Scenario Outline: [TC - 016] Update a valid Spartan
  Given I am on the spartan put api with <id>
  When I input valid spartan credentials with body with <id>:
     """
            {
              "id": <id>,
              "firstName": "<firstName>",
              "lastName": "<lastName>",
              "university": "<university>",
              "degree": "<degree>",
              "course": {
                "id": 0,
                "name": "<courseName>",
                "stream": {
                  "id": <streamId>,
                  "name": "<streamName>",
                  "courses": []
                },
                "streamId": <streamId>,
                "trainer": "<trainer>",
                "startDate": "<startDate>",
                "endDate": "<endDate>",
                "spartans": []
              },
              "courseId": 0,
              "graduated": <graduated>
            }
            """
  Then I should get a HTTP code 204
    Examples:
      | id | firstName | lastName | university          | degree      | courseName | streamId | streamName | trainer       | startDate                | endDate                  | graduated |
      | 1  | Sparty    | McFlyer  | University of Rome  | Time Travel | TECH 301   | 1        | C# Dev     | Phil Anderson | 2027-01-11T09:00:00.000Z | 2027-04-02T17:00:00.000Z | false     |
      | 1  | Sparty    | McFlyer  | University of Rome  | Time Travel | TECH 302   | 1        | C# Dev     | Cathy French  | 2027-05-03T09:00:00.000Z | 2027-07-23T17:00:00.000Z | true      |
      | 1  | Martyn     | Sparton  | University of Milan | Physics     | TECH 303   | 1        | C# Dev     | Nish Mandal   | 2027-09-06T09:00:00.000Z | 2027-11-26T17:00:00.000Z | false     |
  Scenario Outline: [TC - 017] Update an invalid Spartan
  Given I am on the spartan put api with <id>
  When I input invalid spartan credentials with body <id>:
      """
            {
              "id": <id>,
              "firstName": "<firstName>",
              "lastName": "<lastName>",
              "university": "<university>",
              "degree": "<degree>",
              "course": {
                "id": 0,
                "name": "<courseName>",
                "stream": {
                  "id": <streamId>,
                  "name": "<streamName>",
                  "courses": []
                },
                "streamId": <streamId>,
                "trainer": "<trainer>",
                "startDate": "<startDate>",
                "endDate": "<endDate>",
                "spartans": []
              },
              "courseId": 0,
              "graduated": <graduated>
            }
            """
  Then I should get a HTTP code 400
    Examples:
      | id | firstName | lastName | university         | degree      | courseName | streamId | streamName | trainer       | startDate                | endDate                  | graduated |
      | 1  | Sparty    | McFly    | University of Rome | Time Travel | TECH 301   | 1        | C# Dev     | Phil Anderson | 2027-01-11T09:00:00.000Z | 2027-04-02T17:00:00.000Z | false     |