package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By loginLnk = By.linkText("Sign In");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage navigateToLoginPage() {
        driver.findElement(loginLnk).click();
        return new LoginPage(driver);
    }

}
