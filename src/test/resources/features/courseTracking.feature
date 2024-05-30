Feature: courseTracking

  Scenario: new user views courses
    Given I am new to the site
    And I am logged in
    When I visit the courses page
    Then I should see a list of courses with no tags

  Scenario: user can see the courses they've tagged as interested
    Given I am a returning user
    And I am logged in
    When I visit the courses page
    Then I should see the courses I have tagged as interested
    And I should see the courses progress tagged

  Scenario: user wants to tag a course as interested
    Given I am new to the site
    And I am logged in
    When I visit the courses page
    And I click the interested button for a course not tagged as interested
    Then I should see the course tagged as interested

  Scenario: user wants to remove an interest tag from a course
    Given I am a returning user
    And I am logged in
    When I visit the courses page
    And I click the interested button for a course tagged as interested
    Then I should see the courses tag removed
