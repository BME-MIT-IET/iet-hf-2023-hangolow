package com.examples.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Virologist;
import model.agents.*;
import model.codes.BlockCode;
import model.codes.ChoreaCode;
import model.codes.ForgetCode;
import model.codes.StunCode;
import model.map.Field;
import model.map.Warehouse;

import static org.junit.jupiter.api.Assertions.*;

public class AgentStepDefs {

    Virologist userPlayer;
    Agent agentApplied;
    Field startingField;
    int initialAgentCount = 0;

    @Given("a player")
    public void aPlayer() {
        userPlayer = new Virologist();

        //Set fields to move to
        startingField = new Warehouse();
        userPlayer.SetField(startingField);
        for(int i = 0; i < 3; i++)
        {
            Field neighborField = new Warehouse();
            neighborField.AddVirologist(new Virologist());
            startingField.AddNeighbour(neighborField);
        }

        userPlayer.AddGeneticCode(new BlockCode());
        userPlayer.AddGeneticCode(new ChoreaCode());
        userPlayer.AddGeneticCode(new ForgetCode());
        userPlayer.AddGeneticCode(new StunCode());
    }

    @When("the {string} agent is applied to the player")
    public void theAgentIsAppliedToThePlayer(String arg0) {
        switch(arg0)
        {
            case "bear":
                agentApplied = new Bear();
                break;

            case "block":
                agentApplied = new Block(10);
                break;

            case "chorea":
                agentApplied = new Chorea(10);
                break;

            case "forget":
                agentApplied = new Forget(10);
                break;

            case "stun":
                agentApplied = new Stun(10);
                break;
        }

        userPlayer.TargetedWith(agentApplied);
    }

    @Then("the player will start moving randomly infecting others and destroying resources")
    public void thePlayerWillStartMovingRandomlyInfectingOthersAndDestroyingResources() {
        Field targetField = startingField.GetNeighbours().get(0);
        userPlayer.Move(targetField);
        Field currentField = userPlayer.getField();
        assertTrue(currentField != targetField);
        Virologist enemyVirologist = currentField.GetVirologists().get(0);
        int agentCount = enemyVirologist.GetAgentCount();
        assertEquals(1,agentCount);
    }

    @Then("the player will move randomly if they have actions remaining, up to three times")
    public void thePlayerWillMoveRandomlyIfTheyHaveActionsRemainingUpToThreeTimes() {
        assertNotSame(userPlayer.getField(), startingField);
    }

    @Then("the player will forget all the genetic codes")
    public void thePlayerWillForgetAllTheGeneticCodes() {
        int codeCount = userPlayer.GetCodeCount();
        assertEquals(0, codeCount);
    }

    @Then("the player will become vulnerable to looting and will not be ably to use their actions")
    public void thePlayerWillBecomeVulnerableToLootingAndWillNotBeAblyToUseTheirActions() {
        userPlayer.AddAminoAcid(100);
        int aminoCount = userPlayer.GetAminoAcid();
        Virologist enemyPlayer = new Virologist();
        enemyPlayer.LootAminoAcidFrom(userPlayer);
        int aminoCountNew = userPlayer.GetAminoAcid();
        assertTrue(aminoCountNew < aminoCount);

        userPlayer.Move(); // Moves randomly, nothing should happen
        assertEquals(startingField, userPlayer.getField());
    }

    @And("the player has agents applied to them")
    public void thePlayerHasAgentsAppliedToThem() {
        userPlayer.AddAgent(new Chorea(10));
        userPlayer.AddAgent(new Block(10));
        userPlayer.AddAgent(new Stun(10));
        initialAgentCount = userPlayer.GetAgentCount();
    }

    @Then("the player will have their agents removed from them")
    public void thePlayerWillHaveTheirAgentsRemovedFromThem() {
        int agentCount = userPlayer.GetAgentCount();
        assertEquals(1, agentCount);
        assertTrue(agentCount < initialAgentCount);
    }
}
