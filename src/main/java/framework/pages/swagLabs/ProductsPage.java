package framework.pages.swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ProductsPage extends BasePage {

    private final By title = By.cssSelector(".title");
    private final By productNameSelector = By.className("inventory_item_name");
    private final By productPriceSelector = By.className("inventory_item_price");
    private final By sortingDropdownSelector = By.className("product_sort_container");

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

    public void applySortingFilter(String sortingMethodName){
        WebElement sortingDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sortingDropdownSelector));
        Select dropdown = new Select(sortingDropdownElement);
        dropdown.selectByVisibleText(sortingMethodName);
    }
}
