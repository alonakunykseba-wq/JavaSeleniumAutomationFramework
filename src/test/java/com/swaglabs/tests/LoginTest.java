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
                .withFailMessage("page title is not as expected")
                .isEqualTo("Products");
    }
}