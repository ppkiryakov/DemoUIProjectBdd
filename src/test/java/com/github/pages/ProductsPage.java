package com.github.pages;

import com.github.context.ScenarioContext;
import com.github.models.CardItemInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import static com.github.helpers.CardInformationHelper.getCardItemInformation;

public class ProductsPage extends BasePage {
    private By productsList = By.className("inventory_list");
    private By removeButtonList = By.xpath("//button[contains(text(), \"Remove\")]");
    private String specificProduct = "//div[text()='%s']/../../..";
    private String specificProductButton = specificProduct + "//button";
    private String removeProductButton = specificProductButton + "[text()='Remove']";
    private By shoppingCardLocator = By.id("shopping_cart_container");


    public boolean isProductsPageDisplayed() {
        try {
            findElement(productsList);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public void addProductToCart(String product) {
        By specificProductInformation = By.xpath(String.format(specificProduct, product));
        By specificProductButtonLocator = By.xpath(String.format(specificProductButton, product));
        click(specificProductButtonLocator);

        CardItemInformation cardItemInformation = getCardItemInformation(new ProductsPage(), specificProductInformation);
        cardItemInformation.setQuantity(1);

        saveSelectedProductInformationInScenarioContext(product, cardItemInformation);
    }


    public boolean isProductAddedToCart(String addedProductName) {
        By removeProductButtonLocator = By.xpath(String.format(removeProductButton, addedProductName));
        try {
            findElement(removeProductButtonLocator);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public void removeProductFromCart(String addedProductName) {
        By removeProductButtonLocator = By.xpath(String.format(removeProductButton, addedProductName));
        findElement(removeProductButtonLocator).click();

    }

    public void clickShoppingCard() {
        click(shoppingCardLocator);
    }

    private void saveSelectedProductInformationInScenarioContext(String product, Object object) {
        ScenarioContext.setContext(product, object);
    }
}
