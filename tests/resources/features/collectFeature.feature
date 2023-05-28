Feature: Collect
  As a player
  I want to be able to collect different resources

  Scenario: The player collects a given resource
    Given the player has more than 0 remaining moves
    And the player is on a "warehouse" field
    When the player tries to collect resources
    Then the player collects a type of resource randomly
    And the quantity of the resource is increased in the inventory
    And the player loses an action

  Scenario: The player tries to collects a given resource, but their inventory is full
    Given the player has more than 0 remaining moves
    And the player is on a "warehouse" field
    And the player's inventory is full
    When the player tries to collect resources
    Then the player loses an action

  Scenario: The player tries to collects a given resource, but they are on a non-warehouse field
    Given the player has more than 0 remaining moves
    And the player is on a "non-warehouse" field
    When the player tries to collect resources
    Then the player loses an action

  Scenario: The player tries to collects a given resource, but they are stunned
    Given the player is stunned
    When the player tries to collect resources
    Then the player loses an action

  Scenario: The player tries to collects a given resource, but the resources have been destroyed
    Given the player has more than 0 remaining moves
    And the player is on a "warehouse" field
    And a player with the bear virus has previously visited the warehouse
    When the player tries to collect resources
    Then the player loses an action