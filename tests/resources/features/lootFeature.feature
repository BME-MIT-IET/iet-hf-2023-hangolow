Feature: Loot
  As a player
  I want to be able to loot resources and equipments from players

  Scenario: The player loots an equipment
    Given InitLoot
    And there is an enemy player on the same field
    And the enemy player has a valid equipment
    And the enemy player is stunned
    When the user tries to loot an equipment from the enemy player
    Then the player gets an equipment
    And the enemy player loses the equipment
    And the player loses an action

  Scenario: The player loots a AminoAcid
    Given InitLoot
    And there is an enemy player on the same field
    And the enemy player has a Amino Acid
    And the enemy player is stunned
    When the user tries to loot Amino from the enemy player
    Then the player gets amino acid
    And the enemy player loses amino acid
    And the player loses an action

  Scenario: The player loots a Nucleotide
    Given InitLoot
    And there is an enemy player on the same field
    And the enemy player has a Amino Acid
    And the enemy player is stunned
    When the user tries to loot Nucleotide from the enemy player
    Then the player gets Nucleotide
    And the enemy player loses Nucleotide
    And the player loses an action

  Scenario: The player tries to loot an equipment, but the enemy player is not stunned
    Given InitLoot
    And there is an enemy player on the same field
    And the enemy player has a valid equipment
    And the enemy player is not stunned
    When the user tries to loot an equipment from the enemy player
    Then the player loses an action

  Scenario: The player tries to loot Amino acid, but the enemy player is not stunned
    Given InitLoot
    And there is an enemy player on the same field
    And the enemy player has Amino Acid
    And the enemy player is not stunned
    When the user tries to loot Amino from the enemy player
    Then the player loses an action

  Scenario: The player loots a Nucleotide, but the enemy player is not stunned
    Given InitLoot
    And there is an enemy player on the same field
    And the enemy player has Nucleotide
    And the enemy player is not stunned
    When the user tries to loot Nucleotide from the enemy player
    Then the player loses an action

  Scenario: The player tries to loot an equipment, but the enemy player has no valid equipment
    Given InitLoot
    And there is an enemy player on the same field
    And the enemy player has a no valid equipment
    And the enemy player is stunned
    When the user tries to loot an equipment from the enemy player
    Then the player loses an action

  Scenario: The player tries to loot Amino acid, but the enemy player has no Amino acid
    Given InitLoot
    And there is an enemy player on the same field
    And the enemy player has no Amino Acid
    And the enemy player is stunned
    When the user tries to loot Amino from the enemy player
    Then the player loses an action

  Scenario: The player loots a Nucleotide
    Given InitLoot
    And there is an enemy player on the same field
    And the enemy player has a Nucleotide
    And the enemy player is not stunned
    When the user tries to loot Nucleotide from the enemy player
    Then the player loses an action

