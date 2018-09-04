package com.merahkee.cucumber.steps;

import com.merahkee.cucumber.steps.serenity.EnduserStepsForComment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class CommentsAndResponseSteps {

    @Steps
    EnduserStepsForComment commentUser;

    @Given("user is in the Home Page")
    public void inHomePage(){
        commentUser.getPage();
    }


    @When("user clicks on (.*)")
    public void performAction(String option){
        commentUser.ActionOnOption(option);

    }
    @Then("user should see a comment added as (.*)")
    public void result(String result){
        commentUser.getResult(result);
    }

}
