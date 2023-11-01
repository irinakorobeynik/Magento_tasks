package com.coherent.aqa.java.training.web.korobeynik.utilities.waiter;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaiterUtils {
    private WebDriver driver;
    public WaiterUtils(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForElementDisplayed(WebElement element, int sec) {
        new WebDriverWait(driver, Duration.ofSeconds(sec)).until(d -> element.isDisplayed());
    }
}
