package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.driver.Driver;
import com.coherent.aqa.java.training.web.korobeynik.screenshot.ScreenShot;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static java.lang.String.valueOf;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
        getSystemInfo();
    }

    @SneakyThrows
    @Attachment(value = "Page Screenshot", type = "image/png")
    private byte[] takeScreenshot() {
        return ScreenShot.takeSnapShot(Driver.getDriver().openRemoteDriver());
    }

    @SneakyThrows
    @Attachment(value = "Browser/System Info", type = "text/plain")
    private String getSystemInfo() {
        Capabilities cap = ((RemoteWebDriver) Driver.getDriver().openRemoteDriver()).getCapabilities();
        String browserName = cap.getBrowserName();
        String platformName = valueOf(cap.getPlatformName());
        String browserVersion = valueOf(cap.getCapability("browserVersion"));
        return browserName + " " + browserVersion + " " + platformName;
    }

}