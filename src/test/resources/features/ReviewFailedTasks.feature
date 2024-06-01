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
