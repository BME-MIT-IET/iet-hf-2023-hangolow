Feature: Agents
  As a player
  We can have agents applied to us with different effects

  Scenario: The player has the bear agent
    Given a player
    When the "bear" agent is applied to the player
    Then the player will start moving randomly infecting others and destroying resources

  Scenario: The player has the block agent
    Given a player
    And the player has agents applied to them
    When the "block" agent is applied to the player
    Then the player will have their agents removed from them

  Scenario: The player has the chorea agent
    Given a player
    When the "chorea" agent is applied to the player
    Then the player will move randomly if they have actions remaining, up to three times

  Scenario: The player has the forget agent
    Given a player
    When the "forget" agent is applied to the player
    Then the player will forget all the genetic codes

  Scenario: The player has the stun agent
    Given a player
    When the "stun" agent is applied to the player
    Then the player will become vulnerable to looting and will not be ably to use their actions