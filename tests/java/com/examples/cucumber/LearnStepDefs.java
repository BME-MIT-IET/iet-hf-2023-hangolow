package com.examples.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Game;
import model.Virologist;
import model.codes.StunCode;
import model.map.Field;
import model.map.Laboratory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class LearnStepDefs {

    @Given("InitLearn")
    public void initlearn(){
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer = new Virologist();
        context.currentField = new Field();
        context.currentField.AddVirologist(context.userPlayer);
    }

    @And("the genetic code is unknown to the player")
    public void theGeneticCodeIsUnknownToThePlayer() {
        TestWorldContext context = TestWorldContext.Instance();
        StunCode stunCode = new StunCode();
        Laboratory lab = new Laboratory(stunCode);
        context.currentField = lab;
        lab.AddVirologist(context.userPlayer);
    }

    @Then("the player learns a genetic code")
    public void thePlayerLearnsAGeneticCode() {
        TestWorldContext context = TestWorldContext.Instance();

    }

    @And("the genetic code is known to the player")
    public void theGeneticCodeIsKnownToThePlayer() {
        TestWorldContext context = TestWorldContext.Instance();
        for(var item: context.userPlayer.getGeneticCodes()){
            assertTrue(Objects.equals(item, new StunCode()));
        }
    }

    @When("the user tries to learn")
    public void theUserTriesToLearn() {
        TestWorldContext context = TestWorldContext.Instance();
        context.userPlayer.Learn();
    }
}
