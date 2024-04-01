package com.github.steps;

import com.github.pages.CheckoutCompletePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckoutCompleteStepDefinition {
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @And("the Checkout Complete page is loaded")
    public void theCheckoutCompletePageIsLoaded() {
        Assert.assertTrue(checkoutCompletePage.isCheckoutCompletePageDisplayed(), "Checkout Complete page is not displayed.");
    }

    @Then("the Checkout Complete successful message is shown {string}")
    public void theCheckoutCompleteSuccessfulMessageIsShown(String successfulCheckoutCompleteMessage) {
        Assert.assertEquals(checkoutCompletePage.getSuccessfulCheckoutCompleteMessage(), successfulCheckoutCompleteMessage, "Successful Checkout Complete message is not as expected.");
    }
}
