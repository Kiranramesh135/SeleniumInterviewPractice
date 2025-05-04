package com.selenium.interview.practice.pages;

import com.selenium.interview.practice.setup.WebDriverUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="userName")
    WebElement userNameTextField;

    @FindBy(id="password")
    WebElement passwordTextField;

    @FindBy(id="login")
    WebElement loginButton;

    @FindBy(id="name")
    WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20),this);
    }

    public void loginAction( String userName, String password) {
        userNameTextField.sendKeys(userName);
        passwordTextField.sendKeys(password);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
//        jse.executeScript("window.scrollBy(0,-250)");
        loginButton.click();
        Assert.assertEquals(errorMessage.getText(),"Invalid username or password!");


    }




}
