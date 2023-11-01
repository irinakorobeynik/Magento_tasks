package com.coherent.aqa.java.training.web.korobeynik.utilities.base;

import com.coherent.aqa.java.training.web.korobeynik.utilities.waiter.WaiterUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.driver.Driver.getDriver;

public class BasePage {
    protected WebDriver driver;
    protected WaiterUtils wait;

    public BasePage() {
        this.driver = getDriver();
        wait = new WaiterUtils(driver);
    }

    protected boolean isDisplayed(WebElement keyElement) {
        return keyElement.isDisplayed();
    }
}
