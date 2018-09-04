package com.merahkee.cucumber.steps;

import com.merahkee.cucumber.steps.serenity.EndUserStepsForLogin;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class LoginSteps {

    @Steps
    EndUserStepsForLogin endUser;

    @Given("the user is on the MyBlog home page")
    public void givenTheUserIsOnThePebbleHomePage() {
        endUser.is_the_home_page();
    }

    @When("the user enters (.*) and (.*)")
    public void whenTheUserLooksUpTheDefinitionOf(String username,String password) {
        endUser.entersCredencials(username,password);
    }

    @Then("result of the test case should be (.*)")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        endUser.should_see_definition(definition);
    }
}
