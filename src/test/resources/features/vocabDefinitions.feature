Feature: vocab definitions

  Scenario: user wants to view the definition of a word
    Given I am in a lesson
    And The word has a definition
    When I click on the definition button
    Then I should see the definition of the word

  Scenario: user wants to view the definition of an invalid word
    Given I am in a lesson
    And The word does not have a definition
    When I click on the definition button
    Then I should see an alert message pop-up saying unable to find definition
