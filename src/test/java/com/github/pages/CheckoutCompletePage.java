package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

public class CheckoutCompletePage extends BasePage {

    private By checkoutCompleteContainer = By.id("checkout_complete_container");
    private By successfulMessageCompleteText = By.className("complete-text");


    public boolean isCheckoutCompletePageDisplayed() {
        try {
            findElement(checkoutCompleteContainer);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public String getSuccessfulCheckoutCompleteMessage() {
        return getText(successfulMessageCompleteText);
    }
}
