@learningWithAudio
Feature: Learning with Audio

  Scenario: user wants to hear the pronunciation of a word
    Given I am in a lesson
    And I select a word has pronunciation available
    When I click on the pronounce button
    Then I should hear the pronunciation of the word