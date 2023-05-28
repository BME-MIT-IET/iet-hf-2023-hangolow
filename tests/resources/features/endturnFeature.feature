Feature: End turn
  As a player
  I want to be able to end my turn

  Scenario: The player ends their turn
    Given that it is the player's turn
    And the player has 0 or more actions remaining
    When the user ends their turn
    Then the player ends their turn
    And the player's remaining actions are set to 3
