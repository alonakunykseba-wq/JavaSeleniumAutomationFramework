package com.swaglabs.tests;
import com.swaglabs.base.SwagLabsBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends SwagLabsBase {
    @BeforeMethod(dependsOnMethods = "setup")
    public void navigate() {
        driver.get(getProperty("sauce_url"));
    }

    @Test
    public void shouldLoginWithValidCredentials(){
        loginAsStandardUser();
        assertThat(getProductsPage().getPageTitle())
                .withFailMessage("Page title is not as expected")
                .isEqualTo("Products");
    }

    @Test
    public void shouldNotLoginWithInvalidCredentials(){
        driver.get(getProperty("sauce_url"));
        productsPage = loginPage.logInToTheAccount(
                getProperty("locked_out_user"),
                getProperty("common_password")
        );
        assertThat(loginPage.getErrorText())
                .withFailMessage("Error text is not as expected")
                .isEqualTo("Epic sadface: Sorry, this user has been locked out.");
    }
}