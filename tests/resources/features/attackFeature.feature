Feature: Attack
  As a player
  I want to be able to attack different players

  Scenario: The player has no weapon to attack with
    Given InitAttack
    And the player has more than 0 remaining moves
    And has no weapon
    When the player attacks an enemy
    Then the "enemy" player stays alive
    And the player loses an action

  Scenario: The player has a weapon to attack with
    Given InitAttack
    And the player has more than 0 remaining moves
    And has a weapon
    When the player attacks an enemy
    Then kills "the enemy player"
    And the player loses an action

  Scenario: The player has a weapon to attack with and attacks themselves
    Given InitAttack
    And the player has more than 0 remaining moves
    And has a weapon
    When the player attacks themselves
    Then kills "themselves"

  Scenario: The player has no weapon to attack with and attacks themselves
    Given InitAttack
    And the player has more than 0 remaining moves
    And has no weapon
    When the player attacks themselves
    Then the "user" player stays alive
    And the player loses an action

  Scenario: The player tries to attack, but they are stunned
    Given InitAttack
    And the player is stunned
    When the player attacks an enemy
    Then the player loses an action
