Feature: Spartans
  As a user,
  I want to delete a Spartan,

  Scenario Outline: [TC - 009] Deleting a non-existent spartan
    Given I am on the sparta api for an id
    When I enter an invalid id of a non-existent spartan <id>
    Then I should get a <status> code
    Examples:
      | id    | status |
      | 99999 | 404    |
      | 0     | 404    |
      | -1    | 404    |


  Scenario Outline: [TC - 010] Successfully deleting a spartan
    Given I am on the sparta api for an id
    And I create a new spartan with the body:
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
    And I find the ID of the created Spartan
    When I enter a valid id to delete
    Then I should get http code 200

    Examples:
      | firstName     | lastName                 | university                               | degree                                   | courseName                  | streamName             | trainer                      | startDate                | endDate                  | graduated |
      | Bartholomewzx | QuackenbushFizzlewhomp  | Intergalactic Polytechnic of Lower Mars  | BSc Competitive Spoon Juggling with Honours | Advanced Toaster Diplomacy 9000 | Interdimensional QA    | Sir Reginald Wobblebottom III | 2026-11-25T09:00:00.000Z | 2027-02-14T17:00:00.000Z | false     |