package framework.pages.swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return driver.findElement(By.cssSelector(".title")).getText();
    }
}
