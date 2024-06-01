@reviewFailedTasks
Feature: Review Failed Tasks
  Scenario Outline: View list of failed tasks
    Given I am in a lesson
    When I have <amount>% failed tasks
    Then I should see a list of tasks with <amountDescription> failed tasks

    Examples:
    | amount | amountDescription |
    | 0      | no                |
    | 50     | half              |
    | 100    | all               |

  Scenario: Get hint for failed task
    Given I am in a lesson
    And I have a failed task
    When I click on the hint button for the task
    Then I should see a hint for the task
