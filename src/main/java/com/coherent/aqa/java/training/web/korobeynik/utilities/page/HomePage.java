package com.coherent.aqa.java.training.web.korobeynik.utilities.page;

import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By loginLnk = By.linkText("Sign In");

    public HomePage() {
        super();
    }

    public LoginPage navigateToLoginPage() {
        driver.findElement(loginLnk).click();
        return new LoginPage();
    }

}
