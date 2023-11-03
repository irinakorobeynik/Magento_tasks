package com.coherent.aqa.java.training.web.korobeynik.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public final class Driver {
    private static volatile WebDriver driver;

    private Driver() {
        driver.manage().window().maximize();
    }

    public synchronized static WebDriver getDriver() {
            if (driver == null) {
                driver = new ChromeDriver();
            }
            return driver;
        }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

