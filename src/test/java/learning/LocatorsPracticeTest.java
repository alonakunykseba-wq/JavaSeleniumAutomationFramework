package learning;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsPracticeTest extends BaseTest{

    @Test
    public void elementCanBeFoundById(){
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void elementCanBeFoundByName(){
        driver.findElement(By.name("login-button")).click();
    }

    @Test
    public void elementCanBeFoundByCss(){
        driver.findElement(By.cssSelector("#login-button")).click();
    }
}
