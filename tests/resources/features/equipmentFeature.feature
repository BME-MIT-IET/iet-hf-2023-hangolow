Feature: Equipments
  As a player
  I want to be able to have different equipments with certain perks

  Scenario: The player has an axe to attack with
    Given InitEquipment
    And has an axe
    When the user tries to attack an enemy player
    Then kills the enemy player
    And the axe becomes unusable
    And the player loses an action

  Scenario: The player picks up a bag equipment
    Given InitEquipment
    When they pick up a bag
    Then their inventory size increases

  Scenario: The player has a cloak when they try to inject them with an agent
    Given InitEquipment
    When the enemy player tries to inject the player with an agent
    And the player gets lucky
    Then the agent will not be applied to the player

  Scenario: The player has a glove when they try to inject them with an agent
    Given InitEquipment
    When they try to inject the player with an agent
    And the glove has uses remaining
    Then the agent will be reflected back to the sender
    And the gloves remaining number of uses will go down