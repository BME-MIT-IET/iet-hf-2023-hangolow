Feature: Learn
  As a player
  I want to be able to learn different genetic codes

  Scenario: The player learns a genetic code from the laboratory
    Given InitLearn
    And the player is on a "laboratory" field
    And the genetic code is unknown to the player
    When the user tries to learn
    Then the player learns a genetic code
    And the player loses an action

  Scenario: The player tries to learn a genetic code from non-laboratory field
    Given InitLearn
    And the player is on a "non-laboratory" field
    And the genetic code is unknown to the player
    When the user tries to learn
    Then the player loses an action

  Scenario: The player tries to learn a genetic code, but they are stunned
    Given InitLearn
    When the user tries to learn
    Then the player loses an action

  Scenario: The player tries to learn a genetic code from non-laboratory field
    Given InitLearn
    And the player is on a "laboratory" field
    And the genetic code is known to the player
    When the user tries to learn
    Then the player loses an action