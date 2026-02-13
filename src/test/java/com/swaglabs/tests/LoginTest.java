package com.swaglabs.tests;
import com.framework.core.BaseTest;
import framework.pages.swagLabs.LoginPage;
import framework.pages.swagLabs.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    @BeforeMethod(dependsOnMethods = "setup")
    public void navigate() {
        driver.get(getProperty("sauce_url"));
    }

    @Test
    public void shouldLoginWithValidCredentials(){
        String user = getProperty("standard_user");
        String password = getProperty("common_password");
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productPage = loginPage.logInToTheAccount(user, password);
        assertThat(productPage.getPageTitle())
                .withFailMessage("page title is not as expected")
                .isEqualTo("Products");
    }
}
