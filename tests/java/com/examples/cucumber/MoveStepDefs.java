package com.examples.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import model.Game;
import model.Virologist;
import model.agents.Agent;
import model.agents.Bear;
import model.agents.Stun;
import model.codes.BlockCode;
import model.codes.StunCode;
import model.map.Field;
import model.map.InfectedLaboratory;
import model.map.Warehouse;

import static org.junit.jupiter.api.Assertions.*;

public class MoveStepDefs {
    Field prevField;
    Field nextField;

    @Given("InitMove")
    public void initmove(){
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer = new Virologist();
        context.currentField = new Field();
        context.userPlayer.SetField(context.currentField);
    }

    @When("the player tries to move")
    public void thePlayerTriesToMove() {
        TestWorldContext context = TestWorldContext.Instance();
        prevField = context.userPlayer.getField();

        if( nextField != null )
        {
            context.userPlayer.Move(nextField);
        }
        else
        {
            Field f = new Field();
            context.userPlayer.Move(f);
        }

    }

    @Then("the player is moved to the chosen field")
    public void thePlayerIsMovedToTheChosenField() {
        TestWorldContext context = TestWorldContext.Instance();
        assertNotEquals(prevField, context.userPlayer.getField());
    }

    @And("the player has {int} remaining moves")
    public void thePlayerHasRemainingMoves(int arg0) {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.SetActionCount(arg0);
    }

    @Then("the player stays on the same field as before")
    public void thePlayerStaysOnTheSameFieldAsBefore() {
        TestWorldContext context = TestWorldContext.Instance();
        assertEquals(prevField, context.userPlayer.getField());
    }

    @And("the player is infected with the bear virus")
    public void thePlayerIsInfectedWithTheBearVirus() {
        TestWorldContext context = TestWorldContext.Instance();
        boolean hasBear = false;
        for(var virus : context.userPlayer.GetAgents()){
            if(virus.getClass() == Bear.class)
                hasBear = true;
        }
        assertTrue(hasBear);
    }

    @Then("the player is moved to a random field")
    public void thePlayerIsMovedToARandomField() {
        TestWorldContext context = TestWorldContext.Instance();
        assertNotEquals(prevField, context.userPlayer.getField());
    }

    @And("if there are other players on the field, they become infected as well")
    public void ifThereAreOtherPlayersOnTheFieldTheyBecomeInfectedAsWell() {
        TestWorldContext context = TestWorldContext.Instance();
        Virologist v = new Virologist();
        Field f = context.userPlayer.getField();
        f.AddVirologist(v);
        v.AddAgent(new Bear());
    }

    @And("the field has a player infected with the bear virus")
    public void theFieldHasAPlayerInfectedWithTheBearVirus() {
        Virologist bearVirologist = new Virologist();
        nextField = new Field();
        nextField.AddVirologist(bearVirologist);
        bearVirologist.TargetedWith(new Bear());
    }

    @When("the player tries to move to an infected laboratory field")
    public void thePlayerTriesToMoveToAnInfectedLaboratoryField() {
        TestWorldContext context = TestWorldContext.Instance();
        InfectedLaboratory infected = new InfectedLaboratory(new StunCode());
        context.userPlayer.Move(infected);
    }
}
