package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.base.BasePage;
import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Sign In")
    WebElement loginLnk;

    public HomePage(WebDriver driver, WaiterUtils wait) {
        super(driver,wait);
    }

    public LoginPage navigateToLoginPage() {
        loginLnk.click();
        return new LoginPage(driver,wait);
    }

}