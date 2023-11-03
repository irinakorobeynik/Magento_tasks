package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.coherent.aqa.java.training.web.korobeynik.driver.Driver.getDriver;

public class BasePage {
    protected WebDriver driver;
    protected WaiterUtils wait;

    public BasePage(WebDriver driver) {
        this.driver =driver;
        this.wait = WaiterUtils.getInstance(driver);
        PageFactory.initElements(driver,this);
    }

    public BasePage(WebDriver driver, WaiterUtils wait) {
        this.driver =driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    protected boolean isDisplayed(WebElement keyElement) {
        return keyElement.isDisplayed();
    }
}
