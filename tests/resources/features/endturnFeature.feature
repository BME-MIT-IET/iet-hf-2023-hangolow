Feature: End turn
  As a player
  I want to be able to end my turn

  Scenario 1: The player ends their turn
    Given that it's the player's turn
    When the user clicks on "Actions"
    And the user clicks on "endTurn"
    Then the player ends their turn

  Scenario 2: The player ends their turn with the button
    Given that it's the player's turn
    When the user clicks on "EndTurnButton"
    Then the player ends their turn