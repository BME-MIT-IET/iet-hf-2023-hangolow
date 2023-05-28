package com.examples.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Game;
import model.Virologist;
import model.agents.Agent;
import model.agents.Stun;
import model.codes.BlockCode;
import model.codes.StunCode;
import model.equipments.Axe;
import model.map.Field;

import static org.junit.jupiter.api.Assertions.*;

public class AttackStepDefs {
    TestWorldContext context;

    @Before
    public void initialize()
    {
        Game game = Game.Create();
        context = TestWorldContext.GetNewInstance();
        context.userPlayer = new Virologist();
        context.enemyPlayer = new Virologist();
        Virologist dummyPLayer = new Virologist();
        game.NewGame();
        game.AddVirologist(context.userPlayer);
        game.AddVirologist(context.enemyPlayer);
        game.AddVirologist(dummyPLayer);
        Field field = new Field();
        game.AddField(field);
        field.AddVirologist(context.userPlayer);
        field.AddVirologist(context.enemyPlayer);
        field.AddVirologist(dummyPLayer);
        game.AddGeneticCode(new BlockCode());
    }


    @And("has no weapon")
    public void hasNoWeapon() {
        for( var equipment : context.userPlayer.GetEquipments() )
        {
            assertNotSame(equipment.getClass(), Axe.class);
        }
    }

    @And("has a weapon")
    public void hasAWeapon() {
        Axe axe = new Axe();
        context.userPlayer.AddEquipment(axe);
    }

    @Given("the player is stunned")
    public void thePlayerIsStunned() {
        Agent stun = new Stun(10);
        context.userPlayer.AddAgent(stun);
    }

    @When("the player attacks an enemy")
    public void thePlayerAttacksAnEnemy() {
        context.userPlayer.Attack(context.enemyPlayer);
    }

    @When("the player attacks themselves")
    public void thePlayerAttacksThemselves() {
        Game.Create().AddVirologist(context.userPlayer);
        context.userPlayer.Attack(context.userPlayer);
    }

    @Then("the {string} player stays alive")
    public void thePlayerStaysAlive(String arg0) {
        var virologistsAlive = Game.Create().getVirologists();
        boolean isAlive = false;
        Virologist player = null;
        if(arg0.equals("user"))
        {
            player = context.userPlayer;
        }
        else if(arg0.equals("enemy"))
        {
            player = context.enemyPlayer;
        }

        for (var virologist : virologistsAlive)
        {
            if (virologist.equals(player)) {
                isAlive = true;
                break;
            }
        }
        assertTrue(isAlive);
    }

    @Then("kills {string}")
    public void kills(String arg0) {
        var virologistsAlive = Game.Create().getVirologists();
        boolean isAlive = false;
        Virologist player = null;
        if(arg0.equals("themselves"))
        {
            player = context.userPlayer;
        }
        else if(arg0.equals("the enemy player"))
        {
            player = context.enemyPlayer;
        }

        for (var virologist : virologistsAlive)
        {
            if (virologist.equals(player)) {
                isAlive = true;
                break;
            }
        }
        assertFalse(isAlive);
    }
}
