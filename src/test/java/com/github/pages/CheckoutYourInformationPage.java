package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

public class CheckoutYourInformationPage extends BasePage {
    private By checkoutForm = By.className("checkout_info");
    private By firstNameLocator = By.id("first-name");
    private By lastNameLocator = By.id("last-name");
    private By postalCodeLocator = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By errorMessage = By.xpath("//div[contains(@class,'error-message-container')]");
    private By errormessageCloseButton = By.className("error-button");


    public boolean isCheckoutYourInformationPageDisplayed() {
        try {
            findElement(checkoutForm);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public boolean isErrorMessageDisplayed() {
        try {
            findElement(errorMessage);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public void clickErrorMessageCloseButton() {
        click(errormessageCloseButton);
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        sendKeys(firstNameLocator, firstName);
        sendKeys(lastNameLocator, lastName);
        sendKeys(postalCodeLocator, postalCode);
    }
}
