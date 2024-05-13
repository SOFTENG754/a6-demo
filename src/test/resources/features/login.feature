Feature: login

Scenario: login
Given I visit the login page
When I enter "user1" as user name field
And I enter "password" as password field
And I press the submit button
Then I should see the welcome page