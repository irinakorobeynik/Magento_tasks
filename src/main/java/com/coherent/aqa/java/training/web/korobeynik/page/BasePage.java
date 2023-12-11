package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.screenshot.ScreenShot;
import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WaiterUtils wait;
    protected ScreenShot screenShot;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = WaiterUtils.getInstance(driver);
        this.screenShot = ScreenShot.getInstance(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, WaiterUtils wait) {
        this.driver = driver;
        this.wait = wait;
        this.screenShot = ScreenShot.getInstance(driver);
        PageFactory.initElements(driver, this);
    }

    protected boolean isDisplayed(WebElement keyElement, Duration duration) {
        driver.manage().timeouts().implicitlyWait(duration);
        boolean isDisplayed;
        try {
            isDisplayed = keyElement.isDisplayed();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            isDisplayed = false;
        }
        return isDisplayed;

    }

    public boolean doesElementContainsText(WebElement element,String text){
        return element.getText().contains(text);
    }
    public void hoverOverWebElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void clickButtonThatDisables(WebElement element){
        wait.waitForElementClickable(element, Duration.ofSeconds(2));
        element.click();
        wait.waitForElementDisabled(element, Duration.ofSeconds(2));
    }
}
