package com.examples.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Game;
import model.Virologist;
import model.agents.Stun;
import model.codes.StunCode;
import model.equipments.Axe;
import model.equipments.Cloak;
import model.map.Field;
import model.strategy.Looted;

import static org.junit.jupiter.api.Assertions.*;

public class LootStepDefs {


    @Given("InitLoot")
    public void initloot() {
        TestWorldContext context = TestWorldContext.Instance();
        Game game = Game.Create();
        context.userPlayer = new Virologist();
        context.enemyPlayer = new Virologist();
        context.userPlayer.AddNucleotide(10);
        context.userPlayer.AddAminoAcid(10);
        context.enemyPlayer.AddNucleotide(10);
        context.enemyPlayer.AddAminoAcid(10);
        game.NewGame();
        game.AddVirologist(context.userPlayer);
        game.AddVirologist(context.enemyPlayer);
        context.currentField = new Field();
        game.AddField(context.currentField);
        context.currentField.AddVirologist(context.userPlayer);
        context.currentField.AddVirologist(context.enemyPlayer);
    }

    @And("there is an enemy player on the same field")
    public void thereIsAnEnemyPlayerOnTheSameField() {
        TestWorldContext context = TestWorldContext.Instance();
        var virologists = context.currentField.GetVirologists();
        boolean enemyOnField = false;
        boolean userOnField = false;
        for(var virologist : virologists){
            if(virologist.equals(context.enemyPlayer))
                enemyOnField = true;
            if(virologist.equals(context.userPlayer))
                userOnField = true;
        }
        assertTrue(enemyOnField && userOnField);
    }

    @And("the enemy player has a valid equipment")
    public void theEnemyPlayerHasAValidEquipment() {
        TestWorldContext context = TestWorldContext.Instance();
        Axe axe = new Axe();
        axe.setUsed(false);
        context.enemyPlayer.AddEquipment(axe);
        assertFalse(axe.isUsed());
    }

    @And("the enemy player is stunned")
    public void theEnemyPlayerIsStunned() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.Inject(context.enemyPlayer, new StunCode());
    }

    @When("the user tries to loot an equipment from the enemy player")
    public void theUserTriesToLootAnEquipmentFromTheEnemyPlayer() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.LootEquipmentFrom(context.enemyPlayer);
    }

    @Then("the player gets an equipment")
    public void thePlayerGetsAnEquipment() {
        TestWorldContext context = TestWorldContext.Instance();
        assertEquals(1, context.userPlayer.GetEquipments().size());
    }

    @And("the enemy player loses the equipment")
    public void theEnemyPlayerLosesTheEquipment() {
        TestWorldContext context = TestWorldContext.Instance();
        assertEquals(0, context.enemyPlayer.GetEquipments().size());
    }

    @And("the enemy player has a Amino Acid")
    public void theEnemyPlayerHasAAminoAcid() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(context.enemyPlayer.GetAminoAcid()>0);
    }

    @When("the user tries to loot Amino from the enemy player")
    public void theUserTriesToLootAminoFromTheEnemyPlayer() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.LootAminoAcidFrom(context.enemyPlayer);
    }

    @Then("the player gets amino acid")
    public void thePlayerGetsAminoAcid() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(0 < context.userPlayer.GetAminoAcid());
    }

    @And("the enemy player loses amino acid")
    public void theEnemyPlayerLosesAminoAcid() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(10>context.enemyPlayer.GetAminoAcid());
    }

    @When("the user tries to loot Nucleotide from the enemy player")
    public void theUserTriesToLootNucleotideFromTheEnemyPlayer() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.LootNucleotideFrom(context.enemyPlayer);
    }

    @Then("the player gets Nucleotide")
    public void thePlayerGetsNucleotide() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(0 < context.userPlayer.GetNucleotide());
    }

    @And("the enemy player loses Nucleotide")
    public void theEnemyPlayerLosesNucleotide() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(10 > context.enemyPlayer.GetNucleotide());
    }

    @And("the enemy player is not stunned")
    public void theEnemyPlayerIsNotStunned() {
    }

    @And("the enemy player has Amino Acid")
    public void theEnemyPlayerHasAminoAcid() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(context.enemyPlayer.GetAminoAcid()>0);
    }

    @And("the enemy player has Nucleotide")
    public void theEnemyPlayerHasNucleotide() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(context.enemyPlayer.GetNucleotide()>0);
    }

    @And("the enemy player has a no valid equipment")
    public void theEnemyPlayerHasANoValidEquipment() {
        TestWorldContext context = TestWorldContext.Instance();
        var equipments = context.enemyPlayer.GetEquipments();
        assertTrue(equipments.isEmpty());
    }

    @And("the enemy player has no Amino Acid")
    public void theEnemyPlayerHasNoAminoAcid() throws Exception {
        TestWorldContext context = TestWorldContext.Instance();
        context.enemyPlayer.RemoveAminoAcid(context.enemyPlayer.GetAminoAcid());
        assertEquals(0, context.enemyPlayer.GetAminoAcid());
    }

    @And("the enemy player has a Nucleotide")
    public void theEnemyPlayerHasANucleotide() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(context.enemyPlayer.GetNucleotide()>0);
    }
}
