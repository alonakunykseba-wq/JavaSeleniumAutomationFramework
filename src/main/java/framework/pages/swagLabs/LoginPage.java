package framework.pages.swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage logInToTheAccount(String username, String password){
        driver.findElement(By.cssSelector("[placeholder=Username]")).sendKeys(username);
        driver.findElement(By.cssSelector("[placeholder=Password]")).sendKeys(password);
        driver.findElement(By.cssSelector("#login-button")).click();
        return new ProductsPage(driver);
    }

    public String getErrorText(){
        return driver.findElement(By.cssSelector("[data-test=\"error\"]")).getText();
    }

}
