package com.merahkee.cucumber.pages;


import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class LogPage extends PageObject{
    public void ActionOnoption(String option) {
        getDriver().findElement(By.linkText(option)).click();
    }

    public String getPageTitle() {
        String pageTitle=getDriver().findElement(By.xpath(".//*[@id='content']/div/h1")).getText();
        return pageTitle;
    }
}
