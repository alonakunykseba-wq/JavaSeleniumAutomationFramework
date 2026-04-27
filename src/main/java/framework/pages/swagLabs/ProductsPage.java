package framework.pages.swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    private final By title = By.cssSelector(".title");
    private final By productNameSelector = By.className("inventory_item_name");
    private final By productPriceSelector = By.className("inventory_item_price");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(title);
    }

    public ArrayList<String> getProductName() {
        return getTexts(productNameSelector);
    }


    public ArrayList<String> getProductPrice(){
        return getTexts(productPriceSelector);
    }


}
