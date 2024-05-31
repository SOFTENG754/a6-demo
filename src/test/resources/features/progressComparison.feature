Feature: Compare Learning Progress
  Scenario: initialize learning progress
    Given I am a new user to the application
    And I just logged in
    When I navigate to the progress page
    Then I should see my learning progress being initialized