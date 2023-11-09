package com.coherent.aqa.java.training.web.korobeynik.screenshot;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;


public class ScreenShot {
    private static volatile ScreenShot screenShot;
    public WebDriver driver;

    private ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    public synchronized static ScreenShot getInstance(WebDriver driver) {
        if (screenShot == null) {
            screenShot = new ScreenShot(driver);
        }
        return screenShot;
    }


    public void takeSnapShot(WebDriver driver, String fileWithPath) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(fileWithPath);
        try {
            FileUtils.copyFileToDirectory(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
