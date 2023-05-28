Feature: Drop
  As a player
  I want to be able to discard equipments

  Scenario 1: The player has an equipment and tries to drop it
    Given the player has more than 0 remaining moves
    And has at least 1 equipment
    When the player tries to drop an equipment
    Then the player drops the last equipment
    And the player loses an action

  Scenario 2: The player has no equipment but tries to drop something
    Given the player has more than 0 remaining moves
    And has no equipment
    When the player tries to drop an equipment
    Then the player loses an action

  Scenario 3: The player tries to drop an equipment, but they are stunned
    Given the player is stunned
    When the player tries to drop an equipment
    Then the player loses an action