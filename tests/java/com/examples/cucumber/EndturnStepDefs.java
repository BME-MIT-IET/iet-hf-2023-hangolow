package com.examples.cucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Game;
import model.Virologist;
import model.codes.BlockCode;

import static org.junit.jupiter.api.Assertions.*;

public class EndturnStepDefs {
    TestWorldContext context;

    @Before
    public void initialize()
    {
        context = TestWorldContext.GetNewInstance();
        context.userPlayer = new Virologist();
        context.enemyPlayer = new Virologist();
        Game game = Game.Create();
        game.NewGame();
        game.AddVirologist(context.userPlayer);
        game.AddVirologist(context.enemyPlayer);
        game.AddGeneticCode(new BlockCode());
    }

    @Given("that it is the player's turn")
    public void thatItIsThePlayerSTurn() {
        Virologist currentPlayer =  Game.Create().GetCurrentPlayer();
        assertEquals(currentPlayer, context.userPlayer);
    }

    @And("the player has {int} or more actions remaining")
    public void thePlayerHasOrMoreActionsRemaining(int arg0) {
        assertTrue(context.userPlayer.getActionCount() >= arg0);
    }

    @When("the user ends their turn")
    public void theUserEndsTheirTurn() {
        context.userPlayer.EndTurn();
    }

    @Then("the player ends their turn")
    public void thePlayerEndsTheirTurn() {
        assertNotSame(Game.Create().GetCurrentPlayer(), context.userPlayer);
    }

    @And("the player's remaining actions are set to {int}")
    public void thePlayerSRemainingActionsAreSetTo(int arg0) {
        assertEquals(arg0, context.userPlayer.getActionCount());
    }

}
