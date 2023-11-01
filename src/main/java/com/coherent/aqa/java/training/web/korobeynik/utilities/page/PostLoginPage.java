package com.coherent.aqa.java.training.web.korobeynik.utilities.page;

import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostLoginPage extends BasePage {

    @FindBy(css = ".page-header .header li[class='greet welcome']")
    WebElement greetingElement;

    @FindBy(css = ".page-header button[class='action switch']")
    WebElement menuArrow;

    @FindBy(xpath = "//header//a[contains(text(),'Sign Out')]")
    WebElement logoutButton;

    public PostLoginPage() {
        super();
    }

    public boolean isGreetingDisplayed() {
        wait.waitForElementDisplayed(greetingElement, 3);
        return greetingElement.isDisplayed();
    }

    public void openMenu() {
        menuArrow.click();
    }

    public LogoutPage logout() {
        logoutButton.click();
        return new LogoutPage();
    }
}
