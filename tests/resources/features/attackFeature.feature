Feature: Attack
  As a player
  I want to be able to attack different players

  Scenario 1: The player has no weapon to attack with
    Given the player has more than 0 remaining moves
    And has no weapon
    When the user clicks on "Actions"
    And the user clicks on "attack"
    And chooses a enemy player
    Then deals no damage
    And the player loses an action

  Scenario 2: The player has a weapon to attack with
    Given the player has more than 0 remaining moves
    And has a weapon
    When the user clicks on "Actions"
    And the user clicks on "attack"
    And chooses a enemy player
    Then kills the enemy player
    And the player loses an action

  Scenario 3: The player has a weapon to attack with and attacks themselves
    Given the player has more than 0 remaining moves
    And has a weapon
    When the user clicks on "Actions"
    And the user clicks on "attack"
    And chooses themselves
    Then kills themselves

  Scenario 4: The player has no weapon to attack with and attacks themselves
    Given the player has more than 0 remaining moves
    And has no weapon
    When the user clicks on "Actions"
    And the user clicks on "attack"
    And chooses themselves
    Then deals no damage
    And the player loses an action

  Scenario 5: The player tries to attack, but they are stunned
    Given the player is stunned
    When the user clicks on "Actions"
    And the user clicks on "attack"
    Then the player loses an action
