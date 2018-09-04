package com.merahkee.cucumber.steps;

import com.merahkee.cucumber.steps.serenity.EndUserStepsForBlog;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;



public class BlogSteps {

    @Steps
    EndUserStepsForBlog blogger;

    @Given("user login to MyBlog site")
    public void home_page(){
       blogger.open_page();
    }

    @When("user wants to (.*) a blog called (.*)")
    public void action(String task,String blogName){
        blogger.ActionOnOption(task,blogName);
    }

    @Then("(.*) blog should be displayed")
    public void result(String result){
        blogger.result(result);

    }
}

