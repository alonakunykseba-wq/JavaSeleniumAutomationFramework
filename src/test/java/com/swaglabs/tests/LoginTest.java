package com.swaglabs.tests;
import com.swaglabs.base.SwagLabsBase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends SwagLabsBase {

    @Test
    public void verifySuccessfulLoginRedirectsToInventory(){
        loginAsStandardUser();
        assertThat(getProductsOverviewPage().getPageTitle())
                .withFailMessage("Page title is not as expected")
                .isEqualTo("Products");
    }

    @Test
    @Parameters({"login", "password", "expectedErrorMessage"})
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