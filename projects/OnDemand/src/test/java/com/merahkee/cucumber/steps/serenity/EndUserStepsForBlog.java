package com.merahkee.cucumber.steps.serenity;

import com.merahkee.cucumber.pages.BlogPage;
import com.merahkee.cucumber.pages.CreateBlogPage;
import net.thucydides.core.annotations.Step;

import java.io.File;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;


public class EndUserStepsForBlog {
    BlogPage blogPage;
    CreateBlogPage createBlogPage;

    @Step("Login to Pebble Application")
    public void open_page(){
        blogPage.open();
    }

    @Step("Checking for the functionality of the Application")
    public void ActionOnOption(String task,String blogName) {
        blogPage.login();
        blogPage.performActionOn(task,blogName);

    }

    @Step("Verifieng the result of the application")
    public void result(String result) {
        createBlogPage.getResult(result);
    }

    @Step
    public void getText(){
        String content="hello";
        File resourcesDirectory = new File(this.getClass().getResource("src/test/resources/DataSource").getFile());
        assertThat((resourcesDirectory.getAbsolutePath()), containsString(content));

    }

}
