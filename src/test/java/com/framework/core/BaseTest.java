package com.framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties props; // Class-level variable

    @BeforeMethod
    public void setup() {
        props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ChromeOptions options = new ChromeOptions();
        // Disables the password manager and leak detection popups
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--disable-features=PasswordManagerOnboarding");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
