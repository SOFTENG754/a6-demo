@digitalWellbeing
Feature: Digital Wellbeing

  Scenario: Accumulate screen time
    Given the user is using the language learning application
    When the user uses the application for 60 or more minutes
    Then the user's screen time should be stored and accumulated

  Scenario: Prompt to take a break
    Given the user is using the language learning application
    When the user uses the application for 60 or more minutes
    Then the user should be prompted to take a break

  Scenario: Accumulate break time
    Given the user is not using the application
    When the user's break time exceeds five or more minutes
    Then the user's break time should be stored and accumulated

  Scenario: Reset screen time after break
    Given the user is not using the application
    When the user's break time exceeds five or more minutes
    Then the accumulated screen time will reset to 0

