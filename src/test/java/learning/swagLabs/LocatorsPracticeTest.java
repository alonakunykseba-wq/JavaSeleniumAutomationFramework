package learning.swagLabs;

import com.swaglabs.base.SwagLabsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LocatorsPracticeTest extends SwagLabsBase {

    @Test
    public void shouldFindLoginButtonUsingIdAndName(){
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.name("login-button")).click();
    }

    @Test
    public void shouldFindPasswordFieldUsingCssSelectors(){
        driver.findElement(By.cssSelector("#password")).click();//by id
        driver.findElement(By.cssSelector("[placeholder=Password]")).click();
    }

    @Test
    public void shouldFindLoginButtonUsingFullXpath(){
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Test
    public void shouldFindLoginButtonUsingPartialXpath(){
        driver.findElement(By.xpath("//input[contains(@class,'action')]")).click();
    }

    @Test
    public void shouldReadTitleUsingClassName(){
        String title = driver.findElement(By.className("login_logo")).getText();
        assertThat(title).isEqualTo("Swag Labs");
    }

    @Test
    public void shouldFindPasswordHeaderUsingTagName(){
        List<WebElement> h4 = driver.findElements(By.tagName("h4"));
        assertThat(h4.get(1).getText()).isEqualTo("Password for all users:");
    }

    @Test
    public void shouldValidateUsernameFieldAttributesUsingClassName(){
        List<WebElement> formGroupClasses = driver.findElements(By.className("input_error"));
        assertThat(formGroupClasses.size()).isGreaterThan(0);
        assertThat(formGroupClasses.get(0).getAttribute("name")).isEqualTo("user-name");
        assertThat(formGroupClasses.get(0).getAttribute("type")).isEqualTo("text");
        assertThat(formGroupClasses.get(0).getAttribute("id")).isEqualTo("user-name");
        assertThat(formGroupClasses.get(0).getAttribute("placeholder")).isEqualTo("Username");
    }

    @Test
    public void shouldFindLoginButtonUsingRelativeLocators(){
        WebElement button= driver.findElement(By.cssSelector("[type=submit]"));
        RelativeLocator.RelativeBy password_field = RelativeLocator.with(By.tagName("input"));
        WebElement password = driver.findElement(password_field.above(button));
        assertThat(password.getAttribute("type")).isEqualTo("password");
    }
}
