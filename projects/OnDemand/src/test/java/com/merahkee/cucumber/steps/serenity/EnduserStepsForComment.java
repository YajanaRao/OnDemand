package com.merahkee.cucumber.steps.serenity;

import com.merahkee.cucumber.pages.BlogPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EnduserStepsForComment {

    BlogPage blogPage;

    @Step("Open Pebble Home Page")
    public void getPage() {
        blogPage.open();
        blogPage.login();
    }

    @Step("Adding comment to a b_blog")
    public void ActionOnOption(String task) {
        if (task.contains("Add a comment")) {
            blogPage.comment(task);
        } else if (task.contains("Responses")) {
            blogPage.addResponse();
        }
    }


    @Step("Verifidng the result")
    public void getResult(String result) {
        assertThat(blogPage.getPageInfo(),containsString(result));
    }
}
