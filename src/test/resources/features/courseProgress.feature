Feature: course progress
  Scenario: initialize course progress
    Given I am new to the site
    And I am logged in
    And I visit the courses page
    When I selected a new course
    Then see my progress for this course to be initialized
