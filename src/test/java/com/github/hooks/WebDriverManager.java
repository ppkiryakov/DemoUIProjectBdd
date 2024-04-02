package com.github.hooks;

import com.github.context.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static ThreadLocal<WebDriver> driverThreadLocal = ThreadLocal.withInitial(() -> {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/windows/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-infobars");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    });

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @Before
    public void setUp() {
        WebDriverManager.getDriver();
    }

    @After
    public void tearDown() {
        ScenarioContext.clearContext();
        WebDriverManager.getDriver().quit();
    }
}
