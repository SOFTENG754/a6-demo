@learningWithVisualization
Feature: Learning with Visualization

  Scenario: user wants to view the image of a word
    Given I am in a lesson
    And The word has an image
    When I click on the show image button
    Then I should see the image of the word
