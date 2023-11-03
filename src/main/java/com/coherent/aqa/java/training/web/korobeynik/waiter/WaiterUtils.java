package com.coherent.aqa.java.training.web.korobeynik.waiter;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaiterUtils {
    private WebDriver driver;
    public WaiterUtils(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForElementDisplayed(WebElement element, Duration duration) {
        new WebDriverWait(driver, duration).until(d -> element.isDisplayed());
    }
}
