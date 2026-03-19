package com.swaglabs.tests;
import com.swaglabs.base.SwagLabsBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends SwagLabsBase {

    @Test
    public void shouldLoginWithValidCredentials(){
        loginAsStandardUser();
        assertThat(getProductsPage().getPageTitle())
                .withFailMessage("Page title is not as expected")
                .isEqualTo("Products");
    }

    @Test
    public void shouldNotLoginWithLockedUser(){
        productsPage = loginPage.logInToTheAccount(
                getProperty("locked_out_user"),
                getProperty("common_password")
        );
        assertThat(loginPage.getErrorText())
                .withFailMessage("Error text is not as expected")
                .isEqualTo("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void shouldNotLoginWithInvalidCredentials(){
        productsPage = loginPage.logInToTheAccount(
                getProperty("not_existing_user"),
                getProperty("common_password")
        );
        assertThat(loginPage.getErrorText())
                .withFailMessage("Error text is not as expected")
                .isEqualTo("Epic sadface: Username and password do not match any user in this service");
    }
}