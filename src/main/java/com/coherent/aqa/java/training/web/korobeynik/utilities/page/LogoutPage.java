package com.coherent.aqa.java.training.web.korobeynik.utilities.page;

import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BasePage;
import org.openqa.selenium.By;

public class LogoutPage extends BasePage {
    By signOutText = By.xpath("//span[contains(text(), 'You are signed out')]");

    public LogoutPage() {
        super();
    }

    public boolean isSignOutTextDisplayed() {
        wait.waitForElementDisplayed(signOutText, 3);
        return driver.findElement(signOutText).isDisplayed();
    }

    public String getLogOutPage() {
        return driver.getCurrentUrl();
    }
}
