package com.framework.core;

import framework.driver.DriverFactory;
import framework.pages.swagLabs.LoginPage;
import framework.utils.ConfigurationManager;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    public String getProperty(String key) {
        return ConfigurationManager.getProperty(key);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
