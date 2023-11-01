package com.coherent.aqa.java.training.web.korobeynik.utilities.page;

import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BasePage;
import org.openqa.selenium.By;

public class PostLoginPage extends BasePage {
    By greetingElement = By.cssSelector(".page-header .header li[class='greet welcome']");
    By menuArrow = By.cssSelector(".page-header button[class='action switch']");
    By logoutButton = By.xpath("//header//a[contains(text(),'Sign Out')]");

    public PostLoginPage() {
        super();
    }

    public boolean isGreetingDisplayed() {
        wait.waitForElementDisplayed(greetingElement, 3);
        return driver.findElement(greetingElement).isDisplayed();
    }

    public void openMenu() {
        driver.findElement(menuArrow).click();
    }

    public LogoutPage logout() {
        driver.findElement(logoutButton).click();
        return new LogoutPage();
    }
}
