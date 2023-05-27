Feature: Agents
  As a player
  We can have agents applied to us with different effects

  Scenario 1: The player has the bear agent
    Given a player
    When the "bear" agent is applied to the player
    Then the player will start moving randomly infecting others and destroying resources

  Scenario 2: The player has the block agent
    Given a player
    When the "block" agent is applied to the player
    Then the player will be immune to other agents for a time

  Scenario 3: The player has the chorea agent
    Given a player
    When the "chorea" agent is applied to the player
    Then the player will move randomly if they have actions remaining, up to three times

  Scenario 4: The player has the forget agent
    Given a player
    When the "forget" agent is applied to the player
    Then the player will forget all the genetic codes

  Scenario 5: The player has the stun agent
    Given a player
    When the "stun" agent is applied to the player
    Then the player will become vulnerable to looting and will not be ably to use their actions