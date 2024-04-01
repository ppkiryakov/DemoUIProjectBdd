package com.github.pages;


import com.github.hooks.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private WebDriver driver;


    public BasePage() {
        driver = WebDriverManager.getDriver();
    }

    protected void get(String url) {
        driver.get(url);
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected void sendKeys(By element, String text) {
        findElement(element).sendKeys(text);
    }

    protected String getText(By element) {
        return findElement(element).getText();
    }
}
