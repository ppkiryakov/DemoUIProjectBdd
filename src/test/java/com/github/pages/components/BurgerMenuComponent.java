package com.github.pages.components;

import com.github.pages.BasePage;
import org.openqa.selenium.By;

public class BurgerMenuComponent extends BasePage {

    private By burgerMenuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");


    public void clickLogout() {
        click(burgerMenuButton);
        click(logoutLink);
    }
}
