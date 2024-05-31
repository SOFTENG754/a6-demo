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
    When  I select course <courseNumber> which I have completed <lessonCompleted> lessons
    Then I should see my progress for this course to be <progress>

    Examples:
     |courseNumber | lessonCompleted | progress |
     |2            |1                |"1/2"     |
     |3            |2                |"2/3"     |
     |4            |3                |"3/4"     |

