package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.base.BasePage;
import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LogoutPage extends BasePage {
    By signOutText = By.xpath("//span[contains(text(), 'You are signed out')]");

    public LogoutPage(WebDriver driver, WaiterUtils wait) {
        super(driver,wait);
    }

    public boolean isSignOutTextDisplayed() {
        wait.waitForElementDisplayed(signOutText, Duration.ofSeconds(3));
        return driver.findElement(signOutText).isDisplayed();
    }

    public String getLogOutPage() {
        return driver.getCurrentUrl();
    }
}
