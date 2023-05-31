package com.examples.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Virologist;
import model.agents.Block;
import model.agents.Chorea;
import model.codes.ChoreaCode;
import model.map.Field;

import static org.junit.jupiter.api.Assertions.*;

public class InjectStepDefs {

    @Given("InitInject")
    public void initinject(){
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer = new Virologist();
        context.enemyPlayer = new Virologist();
        context.currentField = new Field();
        context.userPlayer.SetField(context.currentField);
    }

    @And("the player lacks the necessary resources to create an agent")
    public void thePlayerLacksTheNecessaryResourcesToCreateAnAgent() {
        TestWorldContext context = TestWorldContext.Instance();
        ChoreaCode chorea = new ChoreaCode();
        context.userPlayer.AddNucleotide(0);
        context.userPlayer.AddAminoAcid(0);
        boolean condition = chorea.getAminoAcidPrice()>context.userPlayer.GetAminoAcid() || chorea.getNucleotidePrice()>context.userPlayer.GetNucleotide();
        assertTrue(condition);
    }

    @And("the enemy player has the Block agent on them")
    public void theEnemyPlayerHasTheBlockAgentOnThem() {
        TestWorldContext context = TestWorldContext.Instance();
        context.enemyPlayer.AddAgent(new Block(10));
    }

    @And("the player has the necessary resources to create an agent")
    public void thePlayerHasTheNecessaryResourcesToCreateAnAgent() {
        TestWorldContext context = TestWorldContext.Instance();
        ChoreaCode chorea = new ChoreaCode();
        context.userPlayer.AddNucleotide(20);
        context.userPlayer.AddAminoAcid(20);
        boolean condition = chorea.getAminoAcidPrice()<=context.userPlayer.GetAminoAcid() && chorea.getNucleotidePrice()<=context.userPlayer.GetNucleotide();
        assertTrue(condition);
    }

    @Then("the chosen player gets the agent applied to them")
    public void theChosenPlayerGetsTheAgentAppliedToThem() {
        TestWorldContext context = TestWorldContext.Instance();
        context.enemyPlayer.AddAgent(new Chorea(10));
    }

    @When("the user tries to inject a player")
    public void theUserTriesToInjectAPlayer() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.Inject(context.enemyPlayer, new ChoreaCode());
    }
}
