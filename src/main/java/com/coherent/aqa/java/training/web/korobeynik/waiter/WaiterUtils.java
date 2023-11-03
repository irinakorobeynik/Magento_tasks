package com.coherent.aqa.java.training.web.korobeynik.waiter;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaiterUtils {
    private WebDriver driver;
    public WaiterUtils(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForElementDisplayed(By element, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
