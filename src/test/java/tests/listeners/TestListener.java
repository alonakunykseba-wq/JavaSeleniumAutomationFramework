package tests.listeners;

import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.base.BaseTest;


public class TestListener implements ITestListener {

    @Attachment(value = "Page Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            saveScreenshotPNG(driver);
        }
    }
}

