package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.screenshot.ScreenShot;
import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected WaiterUtils wait;
    protected ScreenShot screenShot;

    public BasePage(WebDriver driver) {
        this.driver =driver;
        this.wait = WaiterUtils.getInstance(driver);
        this.screenShot = ScreenShot.getInstance(driver);
        PageFactory.initElements(driver,this);
    }

    public BasePage(WebDriver driver, WaiterUtils wait) {
        this.driver =driver;
        this.wait = wait;
        this.screenShot = ScreenShot.getInstance(driver);
        PageFactory.initElements(driver,this);
    }

    protected boolean isDisplayed(WebElement keyElement) {
        return keyElement.isDisplayed();
    }
}
