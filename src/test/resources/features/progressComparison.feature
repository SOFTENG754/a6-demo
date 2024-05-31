Feature: Compare Learning Progress
  Scenario: initialize learning progress
    Given I am a new user to the application
    And I just logged in
    When I navigate to the progress page
    Then I should see my learning progress being initialized

  Scenario: update learning progress
    Given I have visited the application before
    And I just logged in
    And I have completed a few courses
    When I navigate to the progress page
    Then I should see my learning progress as the number of courses I have completed

  Scenario: see other user's progress with valid username
    Given I have visited the application before
    And I just logged in
    And I navigate to the progress page
    When I search for another user's username which exists
    And that user's learning progress is public
    Then I should see their learning progress