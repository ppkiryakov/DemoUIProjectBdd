package com.github.steps;

import com.github.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ShoppingCartStepDefinition {
    CartPage cartPage = new CartPage();

    @And("the Sopping Cart page is loaded")
    public void theSoppingCartPageIsLoaded() {
        Assert.assertTrue(cartPage.isShoppingCartPageDisplayed(), "Shopping Cart page is not displayed.");
    }

    @Then("the user can see the selected product {string} is displayed on Shopping cart page")
    public void theUserCanSeeTheSelectedProductIsDisplayedOnShoppingCartPage(String productName) {
        Assert.assertTrue(cartPage.isProductDisplayed(productName), "Product is not displayed in the cart.");

    }

    @Then("the user can see the selected products {string} and {string} are displayed on Shopping cart page")
    public void theUserCanSeeTheSelectedProductsAndAreDisplayedOnShoppingCartPage(String firstAddedProductName, String secondAddedProductName) {
        theUserCanSeeTheSelectedProductIsDisplayedOnShoppingCartPage(firstAddedProductName);
        theUserCanSeeTheSelectedProductIsDisplayedOnShoppingCartPage(secondAddedProductName);
    }

    @When("the user goes to Checkout page")
    public void theUserGoesToCheckoutPage() {
        cartPage.clickCheckoutButton();
    }
}
