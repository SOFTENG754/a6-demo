@learningWithAudio
Feature: Learning with Audio

  Scenario: user wants to hear the pronunciation of a word
    Given I am in a lesson
    And I select a word has pronunciation available
    When I click on the pronounce button
    Then I should hear the pronunciation of the word

  Scenario: user wants to hear the pronunciation of an invalid word
    Given I am in a lesson
    And I select a word has no pronunciation available
    When I click on the pronounce button
    Then I should see an alert message pop-up saying no pronunciation available

  Scenario: user is informed when error occurs getting image for a word
    Given I am in a lesson
    And The server is down when getting pronunciation
    When I click on the pronounce button
    Then I should see an alert message pop-up saying connection error when getting pronunciation