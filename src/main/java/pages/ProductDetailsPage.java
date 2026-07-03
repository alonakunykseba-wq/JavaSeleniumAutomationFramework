package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BaseProductPage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final By productDetailsNameSelector = By.cssSelector("[data-test='inventory-item-name']");
    private final By productDetailsPriceSelector = By.cssSelector("[data-test='inventory-item-price']");

    public String getProductName() {
        return getText(productDetailsNameSelector);
    }

    public double getProductPrice() {
        return Double.parseDouble(getText(productDetailsPriceSelector).replace("$", ""));
    }
}
