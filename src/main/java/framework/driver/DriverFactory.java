package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "chrome":
            default:

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-features=PasswordLeakDetection");
                options.addArguments("--disable-features=PasswordManagerOnboarding");

                //for GitHub Actions Pipeline!
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");

                driver = new ChromeDriver(options);
                break;
        }
        return driver;
    }
}
