@digitalWellbeing
Feature: Digital Wellbeing
  Background:
    Given the user is using the language learning application

  Scenario: Accumulate screen time
    When the user uses the application for 60 or more minutes
    Then the user's screen time should be stored and accumulated

  Scenario: Prompt to take a break
    When the user uses the application for 60 or more minutes
    Then the user should be prompted to take a break

  Scenario: Accumulate break time
    When the user takes a break that exceeds five or more minutes
    Then the user's break time should be stored and accumulated

  Scenario: Reset screen time after break
    When the user takes a break that exceeds five or more minutes
    Then the accumulated screen time will reset to 0

