Feature: Inject
  As a player
  I want to be able to inject any player with the specified agent

  Scenario: The player tries to inject someone, but they are stunned
    Given InitInject
    When the user tries to inject a player
    Then the player loses an action

  Scenario: The player tries to inject someone, but they lack the resources
    Given InitInject
    And the player lacks the necessary resources to create an agent
    When the user tries to inject a player
    Then the player loses an action

  Scenario: The player tries to inject someone, but they have the Block agent
    Given InitInject
    And the enemy player has the Block agent on them
    When the user tries to inject a player
    Then the player loses an action

  Scenario: The player tries to inject someone with an agent
    Given InitInject
    And the player has the necessary resources to create an agent
    When the user tries to inject a player
    Then the chosen player gets the agent applied to them
    And the player loses an action
