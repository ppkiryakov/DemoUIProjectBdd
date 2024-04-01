package com.github.steps;

import com.github.context.ScenarioContext;
import com.github.models.CardItemInformation;
import com.github.pages.CheckoutOverviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckoutOverviewStepDefinition {
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    @And("the Checkout Overview page is loaded")
    public void theCheckoutOverviewPageIsLoaded() {
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageDisplayed(), "Checkout Overview page is not displayed.");
    }

    @And("the user can see the selected product {string} is displayed on Checkout Overview page")
    public void theUserCanSeeTheSelectedProductIsDisplayedOnCheckoutOverviewPage(String productName) {
        CardItemInformation expected = (CardItemInformation) ScenarioContext.getContext(productName);
        CardItemInformation actual = checkoutOverviewPage.getCartItemInformation(productName);

        Assert.assertTrue(checkoutOverviewPage.isProductDisplayed(productName), "Product is not displayed in the cart.");
        Assert.assertEquals(actual.getName(), expected.getName(), "The Name information for specific product displayed is not correct.");
        Assert.assertEquals(actual.getPrice(), expected.getPrice(), "The Price information for specific product displayed is not correct.");
        Assert.assertEquals(actual.getDescription(), expected.getDescription(), "The Description information for specific product displayed is not correct.");
    }

    @Then("the user can see the selected products {string} and {string} are displayed on Checkout Overview page")
    public void theUserCanSeeTheSelectedProductsAndAreDisplayedOnCheckoutOverviewPage(String firstAddedProductName, String secondAddedProductName) {
        theUserCanSeeTheSelectedProductIsDisplayedOnCheckoutOverviewPage(firstAddedProductName);
        theUserCanSeeTheSelectedProductIsDisplayedOnCheckoutOverviewPage(secondAddedProductName);

    }

    @And("the user clicks Finish button on Checkout Overview page")
    public void theUserClicksFinishButtonOnCheckoutOverviewPage() {
        checkoutOverviewPage.clickFinishButton();
    }
}
