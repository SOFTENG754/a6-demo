@learningWithVisualization
Feature: Learning with Visualization

  Scenario: user wants to view the image of a word
    Given I am in a lesson
    And The word has an image
    When I click on the show image button
    Then I should see the image of the word

  Scenario: user wants to view the image of an invalid word
    Given I am in a lesson
    And The word does not have an image
    When I click on the show image button
    Then I should see the default image

  Scenario: user is informed when error occurs getting image for a word
    Given I am in a lesson
    And The server is down when getting image
    When I click on the show image button
    Then I should see an error message saying connection error