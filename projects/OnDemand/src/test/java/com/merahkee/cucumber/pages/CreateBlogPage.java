package com.merahkee.cucumber.pages;

import java.util.concurrent.TimeUnit;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;

public class CreateBlogPage extends PageObject{

    @FindBy(linkText = "New blog entry")
    private WebElementFacade newBlog;

    @FindBy(name="submit")
    private WebElementFacade button;

    @FindBy(name="title")
    private WebElementFacade blogTitle;

    @FindBy(name="subtitle")
    private WebElementFacade blogSubTitle;

    @FindBy(name="allEntries")
    private WebElementFacade checkBox;

    @FindBy(id="admin-responses-group")
    private WebElementFacade comments;

    @FindBy(name="confirm")
    private WebElementFacade removeCheckbox;

    @FindBy(name="entry")
    private WebElementFacade publishcheckBox;

    @FindBy(name="id")
    private WebElementFacade categoryId;

    @FindBy(name = "name")
    private WebElementFacade categoryName;

    @FindBy(name="file0" )
    private WebElementFacade uploadButton;

    @FindBy(xpath = ".//*[@id='content']/div/div[2]/form[3]/table/tbody/tr[6]/td/input")
    private WebElementFacade fileUpload;

    @FindBy(xpath = ".//*[@id='commentForm']/table/tbody/tr[9]/td/input[2]")
    private WebElementFacade submitComment;

    @FindBy(xpath = ".//*[@id='content']/div[2]/div[2]/form/table/tbody/tr[19]/td/button[1]")
    private WebElementFacade preview;

    @FindBy(xpath = ".//*[@id='content']/div/div[1]/div/form[1]/button[1]")
    private WebElementFacade editbutton;

    @FindBy(xpath = ".//*[@id='content']/div[2]/div[2]/form/table/tbody/tr[19]/td/button[2]")
    private WebElementFacade saveBlog;

    @FindBy(xpath = ".//*[@id='content']/div[2]/div[2]/form/table/tbody/tr[18]/td/button[2]")
    private WebElementFacade save;

    @FindBy(xpath = ".//*[@id='content']/div[1]/div[1]/div/form[1]/button[2]")
    private WebElementFacade publishButton;

    @FindBy(xpath = ".//*[@id='content']/div[1]/div[1]/div/form[1]/button[4]")
    private WebElementFacade removeButton;

    @FindBy(xpath=".//*[@id='admin-content-group']")
    private WebElementFacade content;


    public  void getContent(){
        for(int i=2;i<3;i++){
            ArrayList items = new ArrayList();
            items.add(getDriver().findElements(By.xpath(".//*[@id='content']/div/div[2]/form[1]/table[1]/tbody/tr[i]/td[2]/a")).toString());
            System.out.println(items);
        }

    }

    public void getResult(String result) {
        getDriver().findElement(By.linkText(result)).isDisplayed();
    }

    public void createBlog(String blogName) {
        newBlog.click();
        blogTitle.clear();
        blogTitle.sendKeys(blogName);
        blogSubTitle.sendKeys("Reducing human effort and reducing the error. Automation testing is the new way of living.");
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        preview.click();
       js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        saveBlog.click();
    }

    public void editBlog(String blogName) {
        getDriver().findElement(By.linkText(blogName)).click();
        editbutton.click();
        blogSubTitle.sendKeys("1");
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
       js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        button.click();
       js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        save.click();
    }

    public void publishBlog(String blogName) {
        getDriver().findElement(By.linkText(blogName)).click();
        publishButton.click();
        button.click();
    }

    public void removeBlog(String blogName) {
        getDriver().findElement(By.linkText(blogName)).click();
        removeButton.click();
        removeCheckbox.click();
        removeButton.click();

    }

    public void publishBlogBlogEntries(String task) {
        getDriver().findElement(By.linkText(task)).click();
        publishcheckBox.click();
        button.click();
    }

    public void createCategories(String task) {
        getDriver().findElement(By.linkText(task)).click();
        categoryId.sendKeys("10");
        categoryId.sendKeys("Comedy");
        button.click();
    }

    public void uploadFile(String task) {
        getDriver().findElement(By.linkText(task)).click();
        String file="C:\\Users\\Yajana\\IntellJ\\SerenityProject\\src\\test\\resources\\DataSource\\BlogContent.txt";
        upload(file).to(uploadButton);
        fileUpload.click();
    }

    public void addComment() {
        blogTitle.clear();
        blogTitle.sendKeys("AutomationComment");
        button.click();
        getAlert().accept();
        submitComment.click();
    }

}
