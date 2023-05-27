Feature: Equipments
  As a player
  I want to be able to have different equipments with certain perks

  Scenario 1: The player has an axe to attack with
    Given the player has more than 0 remaining moves
    And has an axe
    When the user clicks on "Actions"
    And the user clicks on "attack"
    And chooses a enemy player
    Then kills the enemy player
    And the axe becomes unusable
    And the player loses an action

  Scenario 2: The player picks up a bag equipment
    Given a player
    When they pick up a bag
    Then their inventory size increases

  Scenario 3: The player has a cloak when they try to inject them with an agent
    Given the player has a cloak
    And an enemy player
    When the enemy player tries to inject the player with an agent
    And the player gets lucky
    Then the agent will not be applied to the player

  Scenario 4: The player has a glove when they try to inject them with an agent
    Given the player has a glove
    And an enemy player
    When they try to inject the player with an agent
    And the glove has uses remaining
    Then the agent will be reflected back to the sender
    And the gloves remaining number of uses will go down