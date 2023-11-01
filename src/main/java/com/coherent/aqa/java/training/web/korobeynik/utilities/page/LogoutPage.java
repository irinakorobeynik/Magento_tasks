package com.coherent.aqa.java.training.web.korobeynik.utilities.page;

import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'You are signed out')]")
    WebElement signOutText;

    public LogoutPage() {
        super();
    }

    public boolean isSignOutTextDisplayed() {
        wait.waitForElementDisplayed(signOutText, 3);
        return signOutText.isDisplayed();
    }

    public String getLogOutPage() {
        return driver.getCurrentUrl();
    }
}
