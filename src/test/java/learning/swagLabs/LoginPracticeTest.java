package learning.swagLabs;

import com.swaglabs.base.SwagLabsBase;
import framework.pages.swagLabs.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPracticeTest extends SwagLabsBase {

    @Test
    public void logInToTheAccountWithKeyboard(){
        driver.findElement(By.cssSelector("[placeholder=Username]")).sendKeys(getProperty("standard_user"));
        driver.findElement(By.cssSelector("[placeholder=Password]")).sendKeys(getProperty("common_password"));
        driver.findElement(By.cssSelector("#login-button")).sendKeys(Keys.ENTER);
        ProductsPage page = new ProductsPage(driver);
        assertThat(page.getPageTitle())
                .withFailMessage("Page title is not as expected")
                .isEqualTo("Products");
    }
}
