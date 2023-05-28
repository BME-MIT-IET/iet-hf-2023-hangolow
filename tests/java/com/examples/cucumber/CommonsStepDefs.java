package com.examples.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Virologist;
import model.agents.Agent;
import model.agents.Stun;
import model.codes.StunCode;
import model.equipments.Cloak;
import model.map.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonsStepDefs {
    TestWorldContext context;

    @Before
    public void initialize()
    {
        context = TestWorldContext.Instance();
    }

    @And("the player loses an action")
    public void thePlayerLosesAnAction() {
        assertTrue(context.userPlayer.getActionCount() < 3);
    }

    @And("the player is on a {string} field")
    public void thePlayerIsOnAField(String arg0) {
        switch (arg0)
        {
            case "warehouse":
                context.currentField = new Warehouse();
                break;
            case "laboratory":
                context.currentField = new Laboratory(new StunCode());
                break;
            case "shelter":
                context.currentField = new Shelter(new Cloak());
                break;
            case "InfectedLaboratory":
                context.currentField = new InfectedLaboratory(new StunCode());
                break;
            case "non-warehouse":
            default:
                context.currentField = new Field();
                break;
        }

        context.userPlayer.SetField(context.currentField);
    }

    @Given("the player has more than {int} remaining moves")
    public void thePlayerHasMoreThanRemainingMoves(int arg0) {
        assertTrue(context.userPlayer.getActionCount() > arg0);
    }


    @When("nothing")
    public void nothing() {}
}
