package com.github.helpers;

import com.github.models.CardItemInformation;
import com.github.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardInformationHelper {

    public static CardItemInformation getCardItemInformation(BasePage basePage, By specificProductInformation) {
        WebElement cardItemElement = basePage.findElement(specificProductInformation);
        String cardItemName = cardItemElement.findElement(By.cssSelector(".inventory_item_name")).getText();
        String cardItemPrice = cardItemElement.findElement(By.cssSelector(".inventory_item_price")).getText();
        String cardItemDescription = cardItemElement.findElement(By.cssSelector(".inventory_item_desc")).getText();

        CardItemInformation cardItemInformation = new CardItemInformation();
        cardItemInformation.setName(cardItemName);
        cardItemInformation.setPrice(Double.parseDouble(cardItemPrice.replace("$", "")));
        cardItemInformation.setDescription(cardItemDescription);

        return cardItemInformation;
    }
}
