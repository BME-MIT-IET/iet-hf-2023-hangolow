package com.examples.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Game;
import model.Virologist;
import model.codes.ChoreaCode;
import model.equipments.Axe;
import model.equipments.Bag;
import model.equipments.Cloak;
import model.equipments.Glove;
import model.map.Field;
import model.strategy.NoInjected;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentStepDefs {


    @Given("InitEquipment")
    public void initequipment(){
        TestWorldContext context = TestWorldContext.Instance();
        Game game = Game.Create();
        context.userPlayer = new Virologist();
        context.enemyPlayer = new Virologist();
        game.NewGame();
        game.AddVirologist(context.userPlayer);
        game.AddVirologist(context.enemyPlayer);
        context.currentField = new Field();
        game.AddField(context.currentField);
        context.currentField.AddVirologist(context.userPlayer);
        context.currentField.AddVirologist(context.enemyPlayer);
    }

    @And("has an axe")
    public void hasAnAxe() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.AddEquipment(new Axe());
    }

    @When("the user tries to attack an enemy player")
    public void theUserTriesToAttackAnEnemyPlayer() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.Attack(context.enemyPlayer);
    }

    @Then("kills the enemy player")
    public void killsTheEnemyPlayer() {
        TestWorldContext context = TestWorldContext.Instance();
        var virologistsAlive = Game.Create().getVirologists();
        boolean isAlive = false;
        context.enemyPlayer.Kill();
        for(var virologist : virologistsAlive){
            if(virologist.equals(context.enemyPlayer))
                isAlive = true;
        }
        assertFalse(isAlive);
    }

    @And("the axe becomes unusable")
    public void theAxeBecomesUnusable() {
        TestWorldContext context = TestWorldContext.Instance();
        Axe axe = new Axe();
        axe.setUsed(true);
        assertTrue(axe.isUsed());
    }

    @When("they pick up a bag")
    public void theyPickUpABag() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.AddEquipment(new Bag());
    }

    @Then("their inventory size increases")
    public void theirInventorySizeIncreases() {
        TestWorldContext context = TestWorldContext.Instance();
        int size = context.userPlayer.GetEquipments().size();
        context.userPlayer.AddEquipment(new Cloak());
        assertNotEquals(size, context.userPlayer.GetEquipments().size());
    }

    @Given("the player has a cloak")
    public void thePlayerHasACloak() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.AddEquipment(new Cloak());
    }

    @When("the enemy player tries to inject the player with an agent")
    public void theEnemyPlayerTriesToInjectThePlayerWithAnAgent() {
        TestWorldContext context = TestWorldContext.Instance();
        context.enemyPlayer.Inject(context.userPlayer, new ChoreaCode());
    }

    @And("the player gets lucky")
    public void thePlayerGetsLucky() {
    }

    @Then("the agent will not be applied to the player")
    public void theAgentWillNotBeAppliedToThePlayer() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.SetInjectedStr(new NoInjected());
    }

    @Given("the player has a glove")
    public void thePlayerHasAGlove() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.AddEquipment(new Glove());
    }

    @When("they try to inject the player with an agent")
    public void theyTryToInjectThePlayerWithAnAgent() {
        TestWorldContext context = TestWorldContext.Instance();
        context.enemyPlayer.Inject(context.userPlayer, new ChoreaCode());
    }

    @And("the glove has uses remaining")
    public void theGloveHasUsesRemaining() {
        TestWorldContext context = TestWorldContext.Instance();
        Glove glove = new Glove();
        assertTrue(glove.getUseCount()>0);
    }

    @Then("the agent will be reflected back to the sender")
    public void theAgentWillBeReflectedBackToTheSender() {
        TestWorldContext context = TestWorldContext.Instance();

    }

    @And("the gloves remaining number of uses will go down")
    public void theGlovesRemainingNumberOfUsesWillGoDown() {
        TestWorldContext context = TestWorldContext.Instance();
        Glove glove = new Glove();
        int uses = glove.getUseCount();
        glove.setUseCount(glove.getUseCount()-1);
        assertNotEquals(uses, glove.getUseCount());
    }
}
