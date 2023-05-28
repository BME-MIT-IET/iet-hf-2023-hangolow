Feature: Inject
  As a player
  I want to be able to inject any player with the specified agent

  Scenario: The player tries to inject someone, but they are stunned
    Given the player is stunned
    When the user clicks on "Actions"
    And the user clicks on "inject"
    And chooses a player
    And chooses an agent
    Then the player loses an action

  Scenario: The player tries to inject someone, but they lack the resources
    Given the player has more than 0 remaining moves
    And the player lacks the necessary resources to create an agent
    When the user clicks on "Actions"
    And the user clicks on "inject"
    And chooses a player
    And chooses an agent
    Then the player loses an action

  Scenario: The player tries to inject someone, but they have the Block agent
    Given the player has more than 0 remaining moves
    And the enemy player has the Block agent on them
    When the user clicks on "Actions"
    And the user clicks on "inject"
    And chooses a player
    And chooses an agent
    Then the player loses an action

  Scenario: The player tries to inject someone with an agent
    Given the player has more than 0 remaining moves
    And the player has the necessary resources to create an agent
    When the user clicks on "Actions"
    And the user clicks on "inject"
    And chooses a player
    And chooses an agent
    Then the chosen player gets the agent applied to them
    And the player loses an action
