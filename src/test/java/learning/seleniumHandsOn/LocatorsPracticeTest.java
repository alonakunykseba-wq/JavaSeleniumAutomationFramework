package learning.seleniumHandsOn;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LocatorsPracticeTest extends BaseTest {

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
