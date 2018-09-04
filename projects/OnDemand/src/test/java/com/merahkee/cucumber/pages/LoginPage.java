package com.merahkee.cucumber.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://192.168.0.7:8765/pebble/")
public class LoginPage extends PageObject {

    @FindBy(name="j_username")
    private WebElementFacade userNameField;

    @FindBy(name="j_password")
    private WebElementFacade passwordField;

    @FindBy(className="loginButtons")
    private WebElementFacade submit;


    public void enters(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        submit.click();
    }

    public String pageTitle() {
        String title=getDriver().getTitle();
        return title;
    }
}