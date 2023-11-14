package com.coherent.aqa.java.training.web.korobeynik.page;

import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.SCREENSHOT_PATH;

public class PostLoginPage extends BasePage {

    @FindBy(css = ".page-header .header li[class='greet welcome'] span[class = 'logged-in']")
    private WebElement greetingElement;

    @FindBy(css = ".page-header button[class='action switch']")
    private WebElement menuArrow;

    @FindBy(xpath = "//header//a[contains(text(),'Sign Out')]")
    private WebElement logoutButton;

    public PostLoginPage(WebDriver driver) {
        super(driver);
    }

    public void makeScreenShot() {
        screenShot.takeSnapShot(driver, SCREENSHOT_PATH);
    }

    public boolean isGreetingDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        boolean isDisplayed;
        try {
            isDisplayed = greetingElement.isDisplayed();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return isDisplayed;
    }

    public void openMenu() {
        menuArrow.click();
    }

    public LogoutPage logout() {
        logoutButton.click();
        return new LogoutPage(driver);
    }
}
