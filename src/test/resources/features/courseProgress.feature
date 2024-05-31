Feature: course progress
  Scenario: initialize course progress
    Given I am new to the site
    And I am logged in
    And I visit the courses page
    When I selected a new course
    Then see my progress for this course to be initialized

  Scenario Outline: update course progress
    Given I am a returning user
    And I am logged in
    And I visit the courses page
    When  I select a course with <numberOfLessons> lessons which I have completed <lessonCompleted> lessons
    Then I should see my progress for this course to be <progress>

    Examples:
      | numberOfLessons | lessonCompleted | progress |
      | 2               |1                |"1/2"     |
      | 2               |2                |"2/2"     |
      | 3               |2                |"2/3"     |

