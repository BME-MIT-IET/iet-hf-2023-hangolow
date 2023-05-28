package com.examples.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Virologist;
import model.equipments.Glove;
import model.map.Field;
import model.map.Shelter;

import static org.junit.jupiter.api.Assertions.*;

public class EquipStepDefs {
    @Given("InitEquip")
    public void initequip() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer = new Virologist();
        context.currentField = new Field();
        context.currentField.AddVirologist(context.userPlayer);
    }

    @And("the field has at least {int} equipment")
    public void theFieldHasAtLeastEquipment(int arg0) {
        TestWorldContext context = TestWorldContext.Instance();
        Shelter shelter = new Shelter(new Glove());

        context.currentField = shelter;
        shelter.AddVirologist(context.userPlayer);
    }

    @And("the player has space in their inventory")
    public void thePlayerHasSpaceInTheirInventory() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(context.userPlayer.GetEquipments().size() < context.userPlayer.GetMaxEquipmentCount());
    }

    @When("the user tries to equip an equipment")
    public void theUserTriesToEquipAnEquipment() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.Equip();
    }

    @Then("an equipment is added to their inventory")
    public void anEquipmentIsAddedToTheirInventory() {
        TestWorldContext context = TestWorldContext.Instance();
        assertTrue(context.userPlayer.GetEquipments().size() > 0);
    }

    @And("the field has no equipment")
    public void theFieldHasNoEquipment() {
        TestWorldContext context = TestWorldContext.Instance();
        Field field = new Field();

        context.currentField = field;
        field.AddVirologist(context.userPlayer);
    }

    @And("the player has no space in their inventory")
    public void thePlayerHasNoSpaceInTheirInventory() {
    }
}
