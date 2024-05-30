Feature: course progress
  Scenario: initialize course progress
    Given I have logged into application
    And I visit the courses page
    When I selected a new course
    Then I should be directed to the course page
    And see my progress for this course to be initialized
