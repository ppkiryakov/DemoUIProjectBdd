package com.github.pages;

import com.github.models.CardItemInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

import static com.github.helpers.CardInformationHelper.getCardItemInformation;

public class CheckoutOverviewPage extends BasePage {

    private By checkoutOverviewContainer = By.id("checkout_summary_container");
    private String specificProductCard = "//div[text()='%s']/../../..";
    private String specificProductNameCart = "//div[@class='cart_item']//div[text()='%s']";
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");


    public boolean isCheckoutOverviewPageDisplayed() {
        try {
            findElement(checkoutOverviewContainer);
            findElement(cancelButton);
            findElement(finishButton);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public boolean isProductDisplayed(String productName) {
        By specificProductNameCartLocator = By.xpath(String.format(specificProductNameCart, productName));
        try {
            findElement(specificProductNameCartLocator);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public void clickFinishButton() {
        click(finishButton);
    }

    public CardItemInformation getCartItemInformation(String productName) {
        By specificProductCardLocator = By.xpath(String.format(specificProductCard, productName));

        CardItemInformation cardItemInformation = getCardItemInformation(new CheckoutOverviewPage(), specificProductCardLocator);

        WebElement cardItemElement = findElement(specificProductCardLocator);
        String cardItemQuantity = cardItemElement.findElement(By.cssSelector(".cart_quantity")).getText();
        cardItemInformation.setQuantity(Integer.parseInt(cardItemQuantity));

        System.out.println("cardItem Name value from Overview screen is: " + cardItemInformation.getName());
        System.out.println("cardItem Price value from Overview screen is: " + cardItemInformation.getPrice());
        System.out.println("cardItem Description value from Overview screen is: " + cardItemInformation.getDescription());
        System.out.println("cardItem QTY value from Overview screen is: " + cardItemInformation.getQuantity());

        return cardItemInformation;
    }
}
