package com.merahkee.cucumber.steps.serenity;

import com.merahkee.cucumber.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EndUserStepsForLogin {

    LoginPage loginPage;

    @Step("Login to the Pebble application using user credentials")
    public void entersCredencials(String username, String password) {
        loginPage.enters(username,password);
    }

    @Step("Opening the Home page")
    public void is_the_home_page() {
        loginPage.open();
    }

    @Step("verifieng the result")
    public void should_see_definition(String result) {
        String title=loginPage.pageTitle();
        if(result.contains("pass")) {
          assertThat(title,containsString("Merahkee"));
        }
        else {
            assertThat(title,containsString("Login - Merahkee"));
        }

    }
}