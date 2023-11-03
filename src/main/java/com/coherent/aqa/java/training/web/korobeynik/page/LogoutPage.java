package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LogoutPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'You are signed out')]")
    private WebElement signOutText;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignOutTextDisplayed() {
        wait.waitForElementDisplayed(signOutText, Duration.ofSeconds(3));
        return signOutText.isDisplayed();
    }

    public String getLogOutPage() {
        return driver.getCurrentUrl();
    }
}
