Feature: Compare Learning Progress
  Scenario: initialize learning progress
    Given I am a new user to the application
    And I just logged in
    When I navigate to the progress page
    Then I should see my learning progress being initialized

  Scenario Outline: update learning progress
    Given I have visited the application before
    And I just logged in
    And I have completed <courseCompleted> courses
    When I navigate to the progress page
    Then I should see my learning progress is <learningProgress>

    Examples:
      | courseCompleted | learningProgress |
      | 3               | "3 courses completed"|
      | 5               | "5 courses completed" |
