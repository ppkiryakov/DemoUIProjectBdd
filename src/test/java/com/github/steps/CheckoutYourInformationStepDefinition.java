package com.github.steps;

import com.github.pages.CheckoutYourInformationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutYourInformationStepDefinition {
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();


    @And("the Checkout Your information page is loaded")
    public void theCheckoutYourInformationPageIsLoaded() {
        Assert.assertTrue(checkoutYourInformationPage.isCheckoutYourInformationPageDisplayed(), "Checkout Your Information page is not displayed.");
    }

    @When("the user clicks continue button on Checkout page")
    public void theUserClicksContinueButtonOnCheckoutPage() {
        checkoutYourInformationPage.clickContinueButton();
    }

    @Then("error message is displayed on Checkout page form")
    public void errorMessageIsDisplayedOnCheckoutPageForm() {
        Assert.assertTrue(checkoutYourInformationPage.isErrorMessageDisplayed(), "Error message is not displayed.");
    }

    @When("the user fills first name {string}, lastname {string} and postal code {string} in the Checkout page form fields")
    public void theUserFillsFirstNameLastnameAndPostalCodeInTheCheckoutPageFormFields(String firstName, String lastName, String postalCode) {
        checkoutYourInformationPage.fillCheckoutForm(firstName, lastName, postalCode);
    }

    @When("the user clear the errors on the Checkout page form")
    public void theUserClearTheErrorsOnTheCheckoutPageForm() {
        checkoutYourInformationPage.clickErrorMessageCloseButton();
    }
}
