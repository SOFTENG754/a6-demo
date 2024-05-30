Feature: courseTracking

  Scenario: new user views courses
    Given I am new to the site
    And I am logged in
    When I visit the courses page
    Then I should see a list of courses, with no tags