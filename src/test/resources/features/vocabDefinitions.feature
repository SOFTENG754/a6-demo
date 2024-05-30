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

  Scenario: user wants to view context examples of a word
    Given I am in a lesson
    And The word has an example
    When I click on the example button
    Then I should see the example of the word

  Scenario: user wants to view examples of an invalid word
    Given I am in a lesson
    And The word does not have any examples
    When I click on the example button
    Then I should see an alert message pop-up saying unable to find any examples

  Scenario: user wants to view synonyms and antonyms of a word
    Given I am in a lesson
    And The word has synonyms and antonyms
    When I click on the synonyms and antonyms button
    Then I should see the synonyms and antonyms of the word

  Scenario: user wants to view synonyms and antonyms of an invalid word
    Given I am in a lesson
    And The word does not have any synonyms or antonyms
    When I click on the synonyms and antonyms button
    Then I should see an alert message pop-up saying unable to find any synonyms or antonyms

  Scenario: user wants information on a word during server connection failure
    Given I am in a lesson
    And The server is down
    When I click on the definition button
    Then I should see an alert message pop-up saying connection error