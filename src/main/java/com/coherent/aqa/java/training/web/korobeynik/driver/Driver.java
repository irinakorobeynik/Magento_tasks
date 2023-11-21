package com.coherent.aqa.java.training.web.korobeynik.driver;

import com.coherent.aqa.java.training.web.korobeynik.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.BROWSER_NAME;
import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.REMOTE_URL;

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

    public WebDriver openRemoteDriver() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(BROWSER_NAME);
        try {
            webDriver = new RemoteWebDriver(new URL(REMOTE_URL), dc);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return webDriver;
    }

    public WebDriver openLocalDriver(String driverOption) {
        switch (driverOption) {
            case "chrome" -> webDriver = new ChromeDriver();
            case "firefox" -> webDriver = new FirefoxDriver();
            case "edge" -> webDriver = new EdgeDriver();
            case "safari" -> webDriver = new SafariDriver();
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
