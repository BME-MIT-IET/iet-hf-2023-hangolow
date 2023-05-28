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
    Virologist userPlayer;
    Virologist enemyPlayer;

    @Before
    public void initialize()
    {
        Game game = Game.Create();
        userPlayer = new Virologist();
        enemyPlayer = new Virologist();
        Virologist dummyPLayer = new Virologist();
        game.NewGame();
        game.AddVirologist(userPlayer);
        game.AddVirologist(enemyPlayer);
        game.AddVirologist(dummyPLayer);
        Field field = new Field();
        game.AddField(field);
        field.AddVirologist(userPlayer);
        field.AddVirologist(enemyPlayer);
        field.AddVirologist(dummyPLayer);
        game.AddGeneticCode(new BlockCode());
    }
    @Given("the player has more than {int} remaining moves")
    public void thePlayerHasMoreThanRemainingMoves(int arg0) {
        assertTrue(userPlayer.getActionCount() > arg0);
    }

    @And("has no weapon")
    public void hasNoWeapon() {
        for( var equipment : userPlayer.GetEquipments() )
        {
            assertNotSame(equipment.getClass(), Axe.class);
        }
    }

    @And("the player loses an action")
    public void thePlayerLosesAnAction() {
        assertTrue(userPlayer.getActionCount() < 3);
    }

    @And("has a weapon")
    public void hasAWeapon() {
        Axe axe = new Axe();
        userPlayer.AddEquipment(axe);
    }

    @Given("the player is stunned")
    public void thePlayerIsStunned() {
        Agent stun = new Stun(10);
        userPlayer.AddAgent(stun);
    }

    @When("the player attacks an enemy")
    public void thePlayerAttacksAnEnemy() {
        userPlayer.Attack(enemyPlayer);
    }

    @When("the player attacks themselves")
    public void thePlayerAttacksThemselves() {
        userPlayer.Attack(userPlayer);
    }

    @Then("the {string} player stays alive")
    public void thePlayerStaysAlive(String arg0) {
        var virologistsAlive = Game.Create().getVirologists();
        boolean isAlive = false;
        Virologist player = null;
        if(arg0.equals("user"))
        {
            player = userPlayer;
        }
        else if(arg0.equals("enemy"))
        {
            player = enemyPlayer;
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
            player = userPlayer;
        }
        else if(arg0.equals("the enemy player"))
        {
            player = enemyPlayer;
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
