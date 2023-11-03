package com.coherent.aqa.java.training.web.korobeynik.base;

import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver driver;
    protected WaiterUtils wait;

    public BasePage(WebDriver driver, WaiterUtils wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected boolean isDisplayed(WebElement keyElement) {
        return keyElement.isDisplayed();
    }
}
