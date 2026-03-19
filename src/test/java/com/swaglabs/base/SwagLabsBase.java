package com.swaglabs.base;

import com.framework.core.BaseTest;
import framework.pages.swagLabs.ProductsPage;
import org.testng.annotations.BeforeMethod;

public class SwagLabsBase extends BaseTest {
    protected ProductsPage productsPage;

    @BeforeMethod(dependsOnMethods = "setup")

    public void navigate() {
        driver.get(getProperty("sauce_url"));
    }
    public ProductsPage getProductsPage() {
        return this.productsPage;
    }
    // A common method to handle the repetitive login steps
    public void loginAsStandardUser() {
        productsPage = loginPage.logInToTheAccount(
                getProperty("standard_user"),
                getProperty("common_password")
        );
    }
}
