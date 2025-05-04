package com.selenium.interview.practice.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtil {

    private static WebDriverUtil instance;

    private WebDriverUtil() {

    }
    public static WebDriverUtil getInstance() {

        if(instance==null) {
            instance = new WebDriverUtil();
        }

        return instance;
    }

    public WebDriver getDriver(String browser) {
        WebDriver driver = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","/Users/kiranramesh/ChromeDriver/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();

        return driver;
    }

}
