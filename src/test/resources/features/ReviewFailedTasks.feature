@reviewFailedTasks
Feature: Review Failed Tasks
  Background:
    Given I am in a lesson

  Scenario Outline: View list of failed tasks
    When I have <amount>% failed tasks
    Then I should see a list of tasks with <amountDescription> failed tasks

    Examples:
    | amount | amountDescription |
    | 0      | no                |
    | 50     | half              |
    | 100    | all               |

  Scenario Outline: Get hint
    And I have a <taskStatus> task
    When I click on the hint button for the task
    Then I <shouldOrShouldNot> see a hint for the task

    Examples:
    | taskStatus | shouldOrShouldNot |
    | failed     | should            |
    | passed     | should not        |

  Scenario: Redo failed task
    And I have a failed task
    When I click on the redo button for the task
    Then I should see the task is reset