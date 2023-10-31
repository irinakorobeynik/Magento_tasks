package com.coherent.aqa.java.training.web.korobeynik.utilities.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public final class Driver {
    public static volatile WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        WebDriver result = driver;
        if (driver != null) {
            return result;
        }
        synchronized (Driver.class) {
            if (driver == null) {
                driver = new ChromeDriver();
            }
            return driver;
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

