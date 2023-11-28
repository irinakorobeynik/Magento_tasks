package com.coherent.aqa.java.training.web.korobeynik.waiter;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaiterUtils {
    private static volatile WaiterUtils wait;
    public WebDriver driver;

    private WaiterUtils(WebDriver driver) {
        this.driver = driver;
    }

    public synchronized static WaiterUtils getInstance(WebDriver driver) {
        if (wait == null) {
            wait = new WaiterUtils(driver);
        }
        return wait;
    }

    public void waitForElementDisplayed(WebElement element, Duration duration) {
        new WebDriverWait(driver, duration).until(d -> element.isDisplayed());
    }

    public void waitForElementClickable(WebElement element, Duration duration) {
        new WebDriverWait(driver, duration).pollingEvery(Duration.ofMillis(50))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementDisabled(WebElement element, Duration duration) {
        new WebDriverWait(driver, duration).pollingEvery(Duration.ofMillis(50))
                .until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
    }

}
