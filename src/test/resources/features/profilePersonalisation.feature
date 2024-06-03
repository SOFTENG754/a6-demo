@profilePersonalisation
Feature: Profile Personalisation

  Scenario: user wants to change to a valid username
    Given I visit the profile page
    When I enter "user1" in the new username field
    And I press the change username button
    Then I should see an alert message pop-up saying username successfully changed

  Scenario: user wants to change their profile picture
    Given I visit the profile page
    When I upload an image file
    And I press the change profile picture button
    Then I should see an alert message pop-up saying profile picture successfully changed
