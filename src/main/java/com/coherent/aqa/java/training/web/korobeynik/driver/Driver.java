package com.coherent.aqa.java.training.web.korobeynik.driver;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;

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


    public WebDriver openRemoteDriver() throws MalformedURLException {
        ClientConfig config = ClientConfig.defaultConfig().connectionTimeout(Duration.ofMinutes(1))
                .readTimeout(Duration.ofMinutes(1));
        switch (BROWSER_NAME) {
            case "chrome" -> webDriver = RemoteWebDriver.builder().oneOf(setChromeOptions()).setCapability("sauce:options", auth())
                    .address(REMOTE_URL).config(config).build();
            case "firefox" -> webDriver = RemoteWebDriver.builder().oneOf(setFireFoxOptions()).setCapability("sauce:options", auth())
                    .address(REMOTE_URL).config(config).build();
            default -> throw new IllegalArgumentException("Invalid browser name" + BROWSER_NAME);
        }
        return webDriver;
    }

    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    private Map<String, Object> auth() {
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", SAUCE_USERNAME);
        sauceOptions.put("accessKey", SAUCE_ACCESS_KEY);
        sauceOptions.put("build", 2);
        sauceOptions.put("name", BROWSER_NAME + BROWSER_VERSION + SAUCE_PLATFORM);
        return sauceOptions;
    }

    private ChromeOptions setChromeOptions() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("unhandledPromptBehavior", "dismiss");
        browserOptions.setPlatformName(SAUCE_PLATFORM);
        browserOptions.setBrowserVersion(BROWSER_VERSION);
        return browserOptions;
    }

    private FirefoxOptions setFireFoxOptions() {
        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setCapability("unhandledPromptBehavior", "dismiss");
        browserOptions.setPlatformName(SAUCE_PLATFORM);
        browserOptions.setBrowserVersion(BROWSER_VERSION);
        return browserOptions;
    }

    public WebDriver openLocalDriver() {
        switch (BROWSER_NAME) {
            case "chrome" -> webDriver = new ChromeDriver();
            case "firefox" -> webDriver = new FirefoxDriver();
            default -> throw new IllegalArgumentException("Invalid browser name" + BROWSER_NAME);
        }
        return webDriver;
    }
}
