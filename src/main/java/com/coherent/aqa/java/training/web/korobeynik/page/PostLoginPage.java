package com.coherent.aqa.java.training.web.korobeynik.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;


public class PostLoginPage extends BasePage {

    @FindBy(css = ".page-header .header li[class='greet welcome'] span[class = 'logged-in']")
    private WebElement greetingElement;

    @FindBy(css = ".page-header button[class='action switch']")
    private WebElement menuArrow;

    @FindBy(xpath = "//header//a[contains(text(),'Sign Out')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//header//a[contains(text(),'My Account')]")
    private WebElement myAccountButton;

    public PostLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isGreetingDisplayed() {
         return isDisplayed(greetingElement, Duration.ofSeconds(3));
    }

    public void openMenu() {
        menuArrow.click();
    }

    public LogoutPage logout() {
        logoutButton.click();
        return new LogoutPage(driver);
    }
    public AccountPage openAccountPage(){
        myAccountButton.click();
        return new AccountPage(driver);
    }
}
