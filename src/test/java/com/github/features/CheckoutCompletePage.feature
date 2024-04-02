Feature: User can complete successfully order


  Background:
    Given the user is on the SauceDemo login page
    And the user login with username "standard_user" and password "secret_sauce"


  Scenario: Verify the user can successfully complete the order of two products
    And the Products page is loaded
    And the user add two products "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt" to the cart
    And the products "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt" are added to the cart on Products page
    And the user remove the products "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt" from the cart on Products page
    And the products "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt" are removed from the cart on Products page
    When the user add two products "Sauce Labs Bike Light" and "Sauce Labs Fleece Jacket" to the cart
    And the products "Sauce Labs Bike Light" and "Sauce Labs Fleece Jacket" are added to the cart on Products page
    And the user goes to the shopping cart
    And the Sopping Cart page is loaded
    And the user can see the selected products "Sauce Labs Bike Light" and "Sauce Labs Fleece Jacket" are displayed on Shopping cart page
    And the user goes to Checkout page
    And the Checkout Your information page is loaded
    And the user clicks continue button on Checkout page
    And error message is displayed on Checkout page form
    And the user clear the errors on the Checkout page form
    And the user fills first name "John", lastname "Doe" and postal code "1000" in the Checkout page form fields
    And the user clicks continue button on Checkout page
    And the Checkout Overview page is loaded
    And the user can see the selected products "Sauce Labs Bike Light" and "Sauce Labs Fleece Jacket" are displayed on Checkout Overview page
    And the user clicks Finish button on Checkout Overview page
    And the Checkout Complete page is loaded
    And the Checkout Complete successful message is shown "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
    And the user clicks Logout