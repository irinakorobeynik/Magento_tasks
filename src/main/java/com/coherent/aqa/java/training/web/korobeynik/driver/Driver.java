package com.coherent.aqa.java.training.web.korobeynik.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public final class Driver {
    private static WebDriver webDriver;
    private static volatile Driver driver;

    private Driver() {
    }

    public synchronized static Driver getDriver() {
        if (driver == null) {
            driver = new Driver();
        }
        return driver;
    }

    public WebDriver openRemoteDriver(DriverOptions driverOption) {
        DesiredCapabilities dc = new DesiredCapabilities();
        switch (driverOption) {
            case CHROME -> dc.setBrowserName("chrome");
            case FIREFOX -> dc.setBrowserName("firefox");
            default -> dc.setBrowserName("chrome");
        }
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return webDriver;
    }

    public WebDriver openLocalDriver(DriverOptions driverOption) {
        switch (driverOption) {
            case CHROME -> webDriver = new ChromeDriver();
            case FIREFOX -> webDriver = new FirefoxDriver();
            default -> webDriver = new ChromeDriver();
        }
        return webDriver;
    }

    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
