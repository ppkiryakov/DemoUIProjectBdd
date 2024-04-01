package com.github.steps;

import com.github.pages.components.BurgerMenuComponent;
import io.cucumber.java.en.And;

public class LogoutStepDefinition {
    BurgerMenuComponent burgerMenuComponent = new BurgerMenuComponent();

    @And("the user clicks Logout")
    public void theUserClicksLogout() {
        burgerMenuComponent.clickLogout();
    }
}
