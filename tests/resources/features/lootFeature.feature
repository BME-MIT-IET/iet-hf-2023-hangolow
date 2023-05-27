Feature: Loot
  As a player
  I want to be able to loot resources and equipments from players

  Scenario 1: The player loots an equipment
    Given the player has more than 0 remaining moves
    And there is an enemy player on the same field
    And the enemy player has a valid equipment
    And the enemy player is stunned
    When the user clicks on "Actions"
    And the user clicks on "lootEquipmentFrom"
    And chooses an enemy player
    Then the player gets an equipment
    And the enemy player loses the equipment
    And the player loses an action

  Scenario 2: The player loots a AminoAcid
    Given the player has more than 0 remaining moves
    And there is an enemy player on the same field
    And the enemy player has a Amino Acid
    And the enemy player is stunned
    When the user clicks on "Actions"
    And the user clicks on "lootAminoFrom"
    And chooses an enemy player
    Then the player gets amino acid
    And the enemy player loses amino acid
    And the player loses an action

  Scenario 3: The player loots a Nucleotide
    Given the player has more than 0 remaining moves
    And there is an enemy player on the same field
    And the enemy player has a Amino Acid
    And the enemy player is stunned
    When the user clicks on "Actions"
    And the user clicks on "lootNucleoFrom"
    And chooses an enemy player
    Then the player gets Nucleotide
    And the enemy player loses Nucleotide
    And the player loses an action

  Scenario 4: The player tries to loot an equipment, but the enemy player is not stunned
    Given the player has more than 0 remaining moves
    And there is an enemy player on the same field
    And the enemy player has a valid equipment
    And the enemy player is not stunned
    When the user clicks on "Actions"
    And the user clicks on "lootEquipmentFrom"
    And chooses an enemy player
    Then the player loses an action

  Scenario 5: The player tries to loot Amino acid, but the enemy player is not stunned
    Given the player has more than 0 remaining moves
    And there is an enemy player on the same field
    And the enemy player has Amino Acid
    And the enemy player is not stunned
    When the user clicks on "Actions"
    And the user clicks on "lootAminoFrom"
    And chooses an enemy player
    Then the player loses an action

  Scenario 6: The player loots a Nucleotide, but the enemy player is not stunned
    Given the player has more than 0 remaining moves
    And there is an enemy player on the same field
    And the enemy player has Nucleotide
    And the enemy player is not stunned
    When the user clicks on "Actions"
    And the user clicks on "lootNucleoFrom"
    And chooses an enemy player
    Then the player loses an action

  Scenario 7: The player tries to loot an equipment, but the enemy player has no valid equipment
    Given the player has more than 0 remaining moves
    And there is an enemy player on the same field
    And the enemy player has a no valid equipment
    And the enemy player is stunned
    When the user clicks on "Actions"
    And the user clicks on "lootEquipmentFrom"
    And chooses an enemy player
    Then the player loses an action

  Scenario 8: The player tries to loot Amino acid, but the enemy player has no Amino acid
    Given the player has more than 0 remaining moves
    And there is an enemy player on the same field
    And the enemy player has no Amino Acid
    And the enemy player is stunned
    When the user clicks on "Actions"
    And the user clicks on "lootAminoFrom"
    And chooses an enemy player
    Then the player loses an action

  Scenario 9: The player loots a Nucleotide
    Given the player has more than 0 remaining moves
    And there is an enemy player on the same field
    And the enemy player has a Nucleotide
    And the enemy player is not stunned
    When the user clicks on "Actions"
    And the user clicks on "lootNucleoFrom"
    And chooses an enemy player
    Then the player loses an action

