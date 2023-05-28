package com.examples.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Virologist;
import model.agents.Bear;
import model.map.Field;
import model.map.Warehouse;

import static org.junit.jupiter.api.Assertions.*;

public class CollectStepDefs {
    TestWorldContext context;

    @Before
    public void initialize()
    {
        context = TestWorldContext.Instance();
        context.userPlayer = new Virologist();
        context.currentField = new Field();
        context.userPlayer.SetField(context.currentField);
    }



    @Then("the player collects a type of resource randomly")
    public void thePlayerCollectsATypeOfResourceRandomly() {
    }

    @And("the quantity of the resource is increased in the inventory")
    public void theQuantityOfTheResourceIsIncreasedInTheInventory() {
        boolean isValueIncreased = context.userPlayer.GetAminoAcid() > 0 || context.userPlayer.GetNucleotide() > 0;
        assertTrue(isValueIncreased);
    }

    @And("the player's inventory is full")
    public void thePlayersInventoryIsFull() {
        context.userPlayer.AddAminoAcid(20);
        context.userPlayer.AddNucleotide(20);
        int aminoCount = context.userPlayer.GetAminoAcid();
        context.userPlayer.AddAminoAcid(10);
        assertEquals(aminoCount, context.userPlayer.GetAminoAcid());

    }

    @And("a player with the bear virus has previously visited the warehouse")
    public void aPlayerWithTheBearVirusHasPreviouslyVisitedTheWarehouse() {
        Virologist bearVirologist = new Virologist();
        Bear bear = new Bear();
        Field prevField = new Field();
        bearVirologist.SetField(prevField);
        bearVirologist.AddAgent(bear);
        var field = context.userPlayer.getField();
        assertEquals(field.getClass(), Warehouse.class);
        bearVirologist.Move(field);
    }

    @When("the player tries to collect resources")
    public void thePlayerTriesToCollectResources() {
        context.userPlayer.Collect();
    }

}
