package com.coherent.aqa.java.training.web.korobeynik.utilities.page;

import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Sign In")
    WebElement loginLnk;

    public HomePage() {
        super();
    }

    public LoginPage navigateToLoginPage() {
        loginLnk.click();
        return new LoginPage();
    }

}
