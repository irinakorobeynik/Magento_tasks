package com.coherent.aqa.java.training.web.korobeynik.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Sign In")
    private WebElement loginLnk;

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage navigateToLoginPage() {
        loginLnk.click();
        return new LoginPage(driver);
    }

    public CreateAccountPage navigateToCreateAccountPage() {
        createAccountLink.click();
        return new CreateAccountPage(driver);
    }



}
