Feature: Equip
  As a player
  I want to be able to pick up equipments from the field

  Scenario 1: The field has an equipment
    Given the player has more than 0 remaining moves
    And the field has at least 1 equipment
    And the player has space in their inventory
    When the user clicks on "Actions"
    And the user clicks on "equip"
    Then an equipment is added to their inventory
    And the player loses an action

  Scenario 2: The field has no equipment
    Given the player has more than 0 remaining moves
    And the field has no equipment
    And the player has space in their inventory
    When the user clicks on "Actions"
    And the user clicks on "equip"
    Then the player loses an action

  Scenario 3: The field has an equipment, but there is no free space in the player's inventory
    Given the player has more than 0 remaining moves
    And the field has at least 1 equipment
    And the player has no space in their inventory
    When the user clicks on "Actions"
    And the user clicks on "equip"
    Then the player loses an action

  Scenario 4: The player tries to pick up an equipment, but they are stunned
    Given the player is stunned
    When the user clicks on "Actions"
    And the user clicks on "equip"
    Then the player loses an action