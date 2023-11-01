package com.coherent.aqa.java.training.web.korobeynik.utilities.page;

import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    By inputUsername = By.name("login[username]");
    By inputPassword = By.name("login[password]");
    By submitButton = By.cssSelector("button[class ='action login primary']");

    public LoginPage() {
        super();
    }

    public void enterUsername(String userName) {
        wait.waitForElementDisplayed(inputUsername, 5);
        driver.findElement(inputUsername).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public PostLoginPage loginToApp() {
        driver.findElement(submitButton).click();
        return new PostLoginPage();
    }

}
