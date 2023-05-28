package com.examples.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Virologist;
import model.equipments.Cloak;
import model.equipments.Equipment;
import model.equipments.Glove;
import model.map.Field;

import static org.junit.jupiter.api.Assertions.*;

public class DropStepDefs {
    Equipment lastEquipment;

    @Given("InitDrop")
    public void initdrop() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer = new Virologist();
        context.currentField = new Field();
        context.currentField.AddVirologist(context.userPlayer);
        Field field = new Field();

    }

    @And("has at least {int} equipment")
    public void hasAtLeastEquipment(int arg0) {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.AddEquipment(new Glove());
        lastEquipment = new Cloak();
        context.userPlayer.AddEquipment(new Glove());
        assertTrue(context.userPlayer.GetEquipments().size() > 0);
    }

    @When("the player tries to drop an equipment")
    public void thePlayerTriesToDropAnEquipment() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.Drop();
    }

    @Then("the player drops the last equipment")
    public void thePlayerDropsTheLastEquipment() {
        TestWorldContext context = TestWorldContext.Instance();
        boolean hasEquipment = false;
        for (var equipment : context.userPlayer.GetEquipments())
        {
            if( equipment.equals(lastEquipment))
                hasEquipment = true;
        }
        assertFalse(hasEquipment);
        assertTrue(context.userPlayer.GetEquipments().size() > 0);
    }

    @And("has no equipment")
    public void hasNoEquipment() {
        TestWorldContext context = TestWorldContext.Instance();
        assertEquals(0, context.userPlayer.GetEquipments().size());
    }

}
