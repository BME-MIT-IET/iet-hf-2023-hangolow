package com.examples.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Virologist;
import model.equipments.Cloak;
import model.equipments.Equipment;
import model.equipments.Glove;

import static org.junit.jupiter.api.Assertions.*;

public class DropStepDefs {
    TestWorldContext context;
    Equipment lastEquipment;

    @Before
    public void initialize()
    {
        context = TestWorldContext.Instance();
        context.userPlayer = new Virologist();
        context.userPlayer.AddEquipment(new Glove());
        lastEquipment = new Cloak();
        context.userPlayer.AddEquipment(new Glove());
    }

    @And("has at least {int} equipment")
    public void hasAtLeastEquipment(int arg0) {
        assertTrue(context.userPlayer.GetEquipments().size() > 0);
    }

    @When("the player tries to drop an equipment")
    public void thePlayerTriesToDropAnEquipment() {
        context.userPlayer.Drop();
    }

    @Then("the player drops the last equipment")
    public void thePlayerDropsTheLastEquipment() {
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
        assertEquals(0, context.userPlayer.GetEquipments().size());
    }
}
