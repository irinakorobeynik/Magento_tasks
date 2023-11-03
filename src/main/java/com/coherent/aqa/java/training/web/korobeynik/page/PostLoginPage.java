package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.base.BasePage;
import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PostLoginPage extends BasePage {
    By greetingElement = By.cssSelector(".page-header .header li[class='greet welcome']");
    By menuArrow = By.cssSelector(".page-header button[class='action switch']");
    By logoutButton = By.xpath("//header//a[contains(text(),'Sign Out')]");

    public PostLoginPage(WebDriver driver, WaiterUtils wait) {
        super(driver,wait);
    }

    public boolean isGreetingDisplayed() {
        wait.waitForElementDisplayed(greetingElement, Duration.ofSeconds(5));
        return driver.findElement(greetingElement).isDisplayed();
    }

    public void openMenu() {
        driver.findElement(menuArrow).click();
    }

    public LogoutPage logout() {
        driver.findElement(logoutButton).click();
        return new LogoutPage(driver,wait);
    }
}
