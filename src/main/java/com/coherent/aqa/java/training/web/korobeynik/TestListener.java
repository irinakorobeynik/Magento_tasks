package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.driver.Driver;
import com.coherent.aqa.java.training.web.korobeynik.driver.DriverOptions;
import com.coherent.aqa.java.training.web.korobeynik.screenshot.ScreenShot;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
        getSystemInfo();
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    private byte[] takeScreenshot() {
        return ScreenShot.takeSnapShot(Driver.getDriver().openRemoteDriver(DriverOptions.CHROME));
    }

    @Attachment(value = "Browser/System Info", type = "text/plain")
    private String getSystemInfo() {
        Capabilities cap = ((RemoteWebDriver) Driver.getDriver().openRemoteDriver(DriverOptions.CHROME)).getCapabilities();
        String browserName = cap.getBrowserName();
        String browserVersion = (String) cap.getCapability("browserVersion");
        return browserName + " " + browserVersion;
    }

}