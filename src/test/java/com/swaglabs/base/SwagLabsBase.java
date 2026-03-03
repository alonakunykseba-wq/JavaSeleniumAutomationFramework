package com.swaglabs.base;

import com.framework.core.BaseTest;
import framework.pages.swagLabs.ProductsPage;

public class SwagLabsBase extends BaseTest {
    protected ProductsPage productsPage;

    public ProductsPage getProductsPage() {
        return this.productsPage;
    }
    // A common method to handle the repetitive login steps
    public void loginAsStandardUser() {
        driver.get(getProperty("sauce_url"));
        productsPage = loginPage.logInToTheAccount(
                getProperty("standard_user"),
                getProperty("common_password")
        );
    }
}
