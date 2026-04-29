package com.swaglabs.tests;
import com.swaglabs.base.SwagLabsBase;

import io.qameta.allure.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends SwagLabsBase {

    @Test
    @Description("""
    Verifies that a standard user with valid credentials can successfully log in and
    is automatically redirected to the main Products Inventory page.
    """)
    public void verifySuccessfulLoginRedirectsToInventory(){
        loginAsStandardUser();
        assertThat(getProductsOverviewPage().getPageTitle())
                .withFailMessage("Page title is not as expected")
                .isEqualTo("Products");
    }

    @Test
    @Description("""
            Data-driven negative test suite.
            Verifies that the system securely intercepts invalid login attempts
            (including locked-out accounts, bad credentials, and empty fields) 
            and correctly displays the expected error message without granting system access.
            """)
    @Parameters({ "login", "password", "expectedErrorMessage"})
    public void verifyErrorMessageWhenLoginIsNotSuccessful(String login, String password, String expectedErrorMessage) {
        loginPage.logInToTheAccount(
                getProperty(login),
                getProperty(password)
        );
        assertThat(loginPage.getErrorText())
                .withFailMessage("Error text is not as expected")
                .isEqualTo(expectedErrorMessage);
    }
}