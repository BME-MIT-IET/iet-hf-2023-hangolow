Feature: Learn
  As a player
  I want to be able to learn different genetic codes

  Scenario: The player learns a genetic code from the laboratory
    Given the player has more than 0 remaining moves
    And the player is on a "laboratory" field
    And the genetic code is unknown to the player
    When the user clicks on "Actions"
    And the user clicks on "learn"
    Then the player learns a genetic code
    And the player loses an action

  Scenario: The player tries to learn a genetic code from non-laboratory field
    Given the player has more than 0 remaining moves
    And the player is on a "non-laboratory" field
    And the genetic code is unknown to the player
    When the user clicks on "Actions"
    And the user clicks on "learn"
    Then the player loses an action

  Scenario: The player tries to learn a genetic code, but they are stunned
    Given the player is stunned
    When the user clicks on "Actions"
    And the user clicks on "learn"
    Then the player loses an action

  Scenario: The player tries to learn a genetic code from non-laboratory field
    Given the player has more than 0 remaining moves
    And the player is on a "laboratory" field
    And the genetic code is known to the player
    When the user clicks on "Actions"
    And the user clicks on "learn"
    Then the player loses an action