Feature: Move
  As a player
  I want to move to a different field

  Scenario: A successful move to another field with moves remaining
    Given the player has more than 0 remaining moves
    When the user clicks on "Actions"
    And the user clicks on "move"
    And chooses a field
    Then the player is moved to the chosen field
    And the player loses an action

  Scenario: A unsuccessful move to another field with no moves remaining
    Given the player has 0 remaining moves
    When the user clicks on "Actions"
    And the user clicks on "move"
    And chooses a field
    Then the player stays on the same field as before
    And the player loses an action

  Scenario: The player tries to move, but is stunned
    Given the player is stunned
    When the user clicks on "Actions"
    And the user clicks on "move"
    And chooses a field
    Then the player stays on the same field as before
    And the player loses an action

  Scenario: The player is infected with the bear virus
    Given the player is infected with the bear virus
    When the user clicks on "Actions"
    And the user clicks on "move"
    And chooses a field
    Then the player is moved to a random field
    And if there are other players on the field, they become infected as well
    And the player loses an action

  Scenario: The player moves to an infected laboratory
    Given the player has more than 0 remaining moves
    When the user clicks on "Actions"
    And the user clicks on "move"
    And chooses an infected laboratory field
    Then the player is moved to the chosen field
    And the player is infected with the bear virus
    And the player loses an action

  Scenario: The player moves to an infected laboratory
    Given the player has more than 0 remaining moves
    When the user clicks on "Actions"
    And the user clicks on "move"
    And chooses a field
    And the field has a player infected with the bear virus
    Then the player is moved to the chosen field
    And the player is infected with the bear virus
    And the player loses an action