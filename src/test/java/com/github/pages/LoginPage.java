package com.github.pages;

import com.github.util.EnvironmentReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By userNameInputField = By.id("user-name");
    private By passwordInputField = By.id("password");
    private By loginButton = By.id("login-button");


    public LoginPage() {

    }


    public void openLoginPage() {
        get(EnvironmentReader.getBaseUrl());
    }

    public void fillUsername(String username) {
        sendKeys(userNameInputField, username);
    }

    public void fillPassword(String password) {
        sendKeys(passwordInputField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void loginWithUser(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLoginButton();
    }
}
