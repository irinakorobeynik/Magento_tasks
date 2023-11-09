package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(name = "login[username]")
    private WebElement inputUsername;

    @FindBy(name = "login[password]")
    private WebElement inputPassword;

    @FindBy(css = ".action.login.primary")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String userName) {
        wait.waitForElementDisplayed(inputUsername, Duration.ofSeconds(5));
        inputUsername.sendKeys(userName);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }


    public PostLoginPage loginToApp() {
        submitButton.click();
        return new PostLoginPage(driver);
    }

}
