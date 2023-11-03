package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.base.BasePage;
import com.coherent.aqa.java.training.web.korobeynik.page.LogoutPage;
import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class PostLoginPage extends BasePage {

    @FindBy(css = ".page-header .header li[class='greet welcome']")
    WebElement greetingElement;

    @FindBy(css = ".page-header button[class='action switch']")
    WebElement menuArrow;

    @FindBy(xpath = "//header//a[contains(text(),'Sign Out')]")
    WebElement logoutButton;

    public PostLoginPage(WebDriver driver, WaiterUtils wait) {
        super(driver,wait);
    }

    public boolean isGreetingDisplayed() {
        wait.waitForElementDisplayed(greetingElement, Duration.ofSeconds(3));
        return greetingElement.isDisplayed();
    }

    public void openMenu() {
        menuArrow.click();
    }

    public LogoutPage logout() {
        logoutButton.click();
        return new LogoutPage(driver,wait);
    }
}
