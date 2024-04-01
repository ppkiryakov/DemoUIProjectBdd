package com.github.steps;

import com.github.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
    private LoginPage loginPage;


    @Given("the user is on the SauceDemo login page")
    public void theUserIsOnTheSauceDemoLoginPage() {
        loginPage = new LoginPage();
        loginPage.openLoginPage();
    }

    @When("the user login with username {string} and password {string}")
    public void theUserLoginWithUsernameAndPassword(String username, String password) {
        loginPage.loginWithUser(username, password);
    }
}
