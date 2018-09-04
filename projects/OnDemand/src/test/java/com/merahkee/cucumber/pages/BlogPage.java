package com.merahkee.cucumber.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("http://192.168.0.7:8765/pebble/")
public class BlogPage extends PageObject{
    CreateBlogPage createBlogPage;

    @FindBy(name="j_username")
    private WebElementFacade userNameField;

    @FindBy(name="j_password")
    private WebElementFacade passwordField;

    @FindBy(className="loginButtons")
    private WebElementFacade submit;

    @FindBy(linkText = "Home")
    private WebElementFacade home;

    @FindBy(xpath=".//*[@id='admin-content-group']")
    private WebElementFacade content;

    @FindBy(xpath = ".//*[@id='admin-logs-group']")
    private WebElementFacade logs;

    public BlogPage() {
    }


    public void login(){
        userNameField.sendKeys("username");
        passwordField.sendKeys("password");
        submit.click();
    }



    public String getPageTitle(){
        String page_title=getDriver().getTitle();
        return page_title;
    }

    public void performActionOn(String task, String blogName) {
        home.click();

        if(task.contains("create")) {
            evaluateJavascript("document.getElementById('admin-content-group').focus()");
            withAction().moveToElement(element(content)).moveToElement(element(content)).click().build().perform();
            //content.click();
            createBlogPage.createBlog(blogName);
        }
        else if(task.contains("edit")){
            createBlogPage.editBlog(blogName);
        }
        else if(task.contains("publish")){
            createBlogPage.publishBlog(blogName);
        }
        else if(task.contains("remove")){
            createBlogPage.removeBlog(blogName);
        }

        else if(task.contains("publishBlogEntries")){
            Actions builder = new Actions(getDriver());
            Actions hoverOverLocationSelector = builder.moveToElement(content);
            content.click();
            createBlogPage.publishBlogBlogEntries(task);
        }

        else if(task.contains("catergories")){
            Actions builder = new Actions(getDriver());
            Actions hoverOverLocationSelector = builder.moveToElement(content);
            content.click();
            createBlogPage.createCategories(task);
        }

        else if(task.contains("Files")){
            Actions builder = new Actions(getDriver());
            Actions hoverOverLocationSelector = builder.moveToElement(content);
            content.click();
            createBlogPage.uploadFile(task);
        }

    }

    public void openLog() {
        home.click();
        evaluateJavascript("document.getElementById('admin-logs-group').focus()");
        logs.click();
    }

    public void comment(String task) {
        getDriver().findElement(By.linkText("Add a comment")).isEnabled();
        getDriver().findElement(By.linkText("Add a comment")).click();
        createBlogPage.addComment();
    }

    public String getPageInfo() {
        String title=getDriver().findElement(net.serenitybdd.core.annotations.findby.By.xpath(".//*[@id='content']/div/h1")).getText();
        return title;
    }

    public void addResponse() {
        getDriver().findElement(By.partialLinkText("Responses")).click();
    }
}
