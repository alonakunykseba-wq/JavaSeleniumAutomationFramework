package com.framework.core;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {

    @Attachment(value = "Page Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName() + " - Taking screenshot!");

        Object testClass = result.getInstance();

        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver != null) {
            saveScreenshotPNG(driver);
        }
    }
}

