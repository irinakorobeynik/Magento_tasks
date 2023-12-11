package com.coherent.aqa.java.training.web.korobeynik.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Thank you for registering with Main Website Store.')]")
    private WebElement accountCreationText;

    @FindBy(linkText ="Address Book")
    private WebElement addressBookLink;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreationTextDisplayed() {
        return isDisplayed(accountCreationText, Duration.ofSeconds(5));
    }

    public AddressPage navigateToAddressPage(){
        addressBookLink.click();
        return new AddressPage(driver);
    }
}
