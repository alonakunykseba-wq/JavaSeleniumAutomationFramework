package learning.seleniumHandsOn;

import com.framework.core.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LocatorsPracticeTest extends BaseTest {
    @BeforeMethod(dependsOnMethods = "setup")
    public void navigate() {
        driver.get(getProperty("bonigarcia_url"));
    }

    @Test
    public void shouldOpenIndexPageWhenLinkTextIsClicked(){
        driver.findElement(By.linkText("Return to index")).click();
        String title = driver.findElement(By.tagName("h1")).getText();
        assertThat(title).isEqualTo("Hands-On Selenium WebDriver with Java");
    }

    @Test
    public void shouldSelectDateUsingRelativeLocators(){

    }
}
