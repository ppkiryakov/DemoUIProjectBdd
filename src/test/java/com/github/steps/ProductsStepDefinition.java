package com.github.steps;

import com.github.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductsStepDefinition {
    private ProductsPage productsPage = new ProductsPage();


    @Then("the Products page is loaded")
    public void theProductsPageIsLoaded() {
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Products page is not displayed.");
    }

    @When("the user add two products {string} and {string} to the cart")
    public void theUserAddTwoProductsAndToTheCart(String firstAddedProduct, String secondAddedProduct) {
        theUserAddProductToTheCart(firstAddedProduct);
        theUserAddProductToTheCart(secondAddedProduct);
    }

    @When("the user add product {string} to the cart")
    public void theUserAddProductToTheCart(String product) {
        productsPage.addProductToCart(product);
    }

    @Then("the product {string} is added to the card on Products page")
    public void theProductIsAddedToTheCardOnProductsPage(String addedProduct) {
        Assert.assertTrue(productsPage.isProductAddedToCart(addedProduct), "Product is not added to cart.");
    }

    @Then("the products {string} and {string} are added to the cart on Products page")
    public void theProductsAndAreAddedToTheCartOnProductsPage(String firstAddedProduct, String secondAddedProduct) {
        theProductIsAddedToTheCardOnProductsPage(firstAddedProduct);
        theProductIsAddedToTheCardOnProductsPage(secondAddedProduct);
    }

    @When("the user remove the product {string} from the cart on Products page")
    public void theUserRemoveTheProductFromTheCartOnProductsPage(String productName) {
        productsPage.removeProductFromCart(productName);
    }

    @And("the user remove the products {string} and {string} from the cart on Products page")
    public void theUserRemoveTheProductsAndFromTheCartOnProductsPage(String firstAddedProductName, String secondAddedProductName) {
        theUserRemoveTheProductFromTheCartOnProductsPage(firstAddedProductName);
        theUserRemoveTheProductFromTheCartOnProductsPage(secondAddedProductName);
    }

    @Then("the product {string} is removed from the cart on Products page")
    public void theProductIsRemovedFromTheCartOnProductsPage(String productName) {
        Assert.assertFalse(productsPage.isProductAddedToCart(productName), "Product is not removed from cart.");
    }

    @Then("the products {string} and {string} are removed from the cart on Products page")
    public void theProductsAndAreRemovedFromTheCartOnProductsPage(String firstAddedProductName, String secondAddedProductName) {
        theProductIsRemovedFromTheCartOnProductsPage(firstAddedProductName);
        theProductIsRemovedFromTheCartOnProductsPage(secondAddedProductName);
    }

    @When("the user goes to the shopping cart")
    public void theUserGoesToTheShoppingCart() {
        productsPage.clickShoppingCard();
    }
}
