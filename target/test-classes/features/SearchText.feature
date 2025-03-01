Feature: Manage my Todos effectively

  As a user
  I want to be able to manage my todos
  So that I can keep track of my tasks and stay organized

  @SmokeTest
  Scenario: User adds multiple todo items to the list
    Given User is on todos application page
    When the user adds the following todo items:
    | Learn Cucumber |
    | Learn Java |
    | Learn Jenkins |
    Then the new todo items should appear in the todo list
    And It should be moved to the completed todo section when select the todo item 
    And Delete the active todo item from the todo list when user verified the active todo list