package com.swaglabs.tests;

import com.swaglabs.base.SwagLabsBase;
import framework.pages.swagLabs.ProductDetailsPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest extends SwagLabsBase {
    protected SoftAssertions softly;
    @BeforeMethod
    public void setupTestState() {
       softly = new SoftAssertions();
        loginAsStandardUser();
        assertThat(getProductsOverviewPage().getPageTitle())
                .withFailMessage("Page title is not as expected")
                .isEqualTo("Products");
    }

    @Test(description = "TC-05: verifyProductCatalogCountAndBrandingConsistency")
    public void verifyProductCatalogCountAndBrandingConsistency() {

        List<String> productNamesList = productsOverviewPage.getProductNames();
        List<String> badNames = productNamesList.stream()
                .filter(name -> !name.toLowerCase().startsWith("sauce") && !name.toLowerCase().contains("labs"))
                .toList();

        softly.assertThat(badNames)
                .withFailMessage("Products which don't contain 'Sauce Labs' are: " + badNames)
                .isEmpty();
        softly.assertThat(productNamesList.size())
                .withFailMessage("The products page contains less products than expected")
                .isEqualTo(6);
        softly.assertThat(productsOverviewPage.getProductPrices())
                .withFailMessage("Product price currency is not USD")
                .allMatch(price -> price.startsWith("$"));
        softly.assertAll();
    }

    @Test (description ="TC-06: verifyHighToLowPriceSortingLogic")
    public void verifyHighToLowPriceSortingLogic(){
        productsOverviewPage.applySortingFilter("Price (high to low)");
        List<String> productPriceList = productsOverviewPage.getProductPrices();
        List<Double> sortedPriceList = productPriceList.stream()
                .map(price->Double.parseDouble(price.replace("$", "") ))
                .toList();
        assertThat(sortedPriceList)
                .withFailMessage("The prices are not sorted in descending order")
                .isSortedAccordingTo(Comparator.reverseOrder());
    }

    @Test (description = "TC-12: verifyProductDetailsMatchCatalogInformation")
    public void verifyProductDetailsMatchCatalogInformation(){
        String expectedName = productsOverviewPage.selectRandomProductName();
        double expectedPrice = productsOverviewPage.getProductPriceByName(expectedName);
        ProductDetailsPage details = productsOverviewPage.clickRandomProductLink(expectedName);
        softly.assertThat(details.getProductName())
                .withFailMessage("Product name is not the same as one in the overview page")
                .isEqualTo(expectedName);
        softly.assertThat(details.getProductPrice())
                .withFailMessage("Product price is not the same as one in the overview page")
                .isEqualTo(expectedPrice);
        softly.assertAll();
    }
}
