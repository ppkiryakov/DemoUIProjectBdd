package com.github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

public class CartPage extends BasePage {
    private By cartItemList = By.className("cart_list");
    private By checkoutButton = By.id("checkout");
    private String specificProductNameCart = "//div[@class='cart_item']//div[text()='%s']";


    public boolean isShoppingCartPageDisplayed() {
        try {
            findElement(cartItemList);
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

    public void clickCheckoutButton() {
        click(checkoutButton);
    }
}
