package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage extends BasePage {
    private By inputUsername = By.name("login[username]");
    private By inputPassword = By.name("login[password]");
    private By submitButton = By.cssSelector(" .action.login.primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String userName) {
        wait.waitForElementDisplayed(inputUsername, Duration.ofSeconds(5));
        driver.findElement(inputUsername).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public PostLoginPage loginToApp() {
        driver.findElement(submitButton).click();
        return new PostLoginPage(driver);
    }

}
