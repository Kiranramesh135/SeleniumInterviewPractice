package com.selenium.interview.practice.tests;

import com.selenium.interview.practice.pages.LoginPage;
import com.selenium.interview.practice.setup.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Initialize {

    public static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverUtil webDriverUtil = WebDriverUtil.getInstance();
        driver = webDriverUtil.getDriver("chrome");
    }

    @Test
    public void testFlow() {
        driver.get("https://demoqa.com/books");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("login")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAction("admin","pwd");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
