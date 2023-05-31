Feature: Equip
  As a player
  I want to be able to pick up equipments from the field

  Scenario: The field has an equipment
    Given InitEquip
    And the player has more than 0 remaining moves
    And the field has at least 1 equipment
    And the player has space in their inventory
    When the user tries to equip an equipment
    Then an equipment is added to their inventory
    And the player loses an action

  Scenario: The field has no equipment
    Given InitEquip
    And the player has more than 0 remaining moves
    And the field has no equipment
    And the player has space in their inventory
    When the user tries to equip an equipment
    Then the player loses an action

  Scenario: The field has an equipment, but there is no free space in the player's inventory
    Given InitEquip
    And the player has more than 0 remaining moves
    And the field has at least 1 equipment
    And the player has no space in their inventory
    When the user tries to equip an equipment
    Then the player loses an action

  Scenario: The player tries to pick up an equipment, but they are stunned
    Given InitEquip
    And the player is stunned
    When the user tries to equip an equipment
    Then the player loses an action