package com.coherent.aqa.java.training.web.korobeynik.utilities.page;

import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "login[username]")
    WebElement inputUsername;

    @FindBy(name = "login[password]")
    WebElement inputPassword;

    @FindBy(css = "button[class ='action login primary']")
    WebElement submitButton;

    public LoginPage() {
        super();
    }

    public void enterUsername(String userName) {
        wait.waitForElementDisplayed(inputUsername, 5);
        inputUsername.sendKeys(userName);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public PostLoginPage loginToApp() {
        submitButton.click();
        return new PostLoginPage();
    }

}
