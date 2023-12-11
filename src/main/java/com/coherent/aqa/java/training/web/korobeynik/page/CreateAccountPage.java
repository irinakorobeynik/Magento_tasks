package com.coherent.aqa.java.training.web.korobeynik.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class CreateAccountPage extends BasePage {
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(css = "#email_address")
    private WebElement emailAddressInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordInput;

    @FindBy(css = ".action.submit.primary")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[contains(text(),'This is a required field.')]")
    private WebElement requiredFieldError;

    @FindBy(id = "password-confirmation-error")
    private WebElement passwordConfirmationError;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateAccountButtonWithoutFillingFields() {
        createAccountButton.click();
    }

    public AccountPage clickCreateAccountButtonWithFilledFields() {
        createAccountButton.click();
        return new AccountPage(driver);
    }

    public void enterFirstName(String inputValue) {
        firstNameInput.sendKeys(inputValue);
    }

    public void enterLastName(String inputValue) {
        lastNameInput.sendKeys(inputValue);
    }

    public void enterEmail(String inputValue) {
        emailAddressInput.sendKeys(inputValue);
    }

    public void enterPassword(String inputValue) {
        passwordInput.sendKeys(inputValue);
    }

    public void confirmPassword(String inputValue) {
        confirmPasswordInput.sendKeys(inputValue);
    }

    public void isRequiredFieldErrorDisplayed() {
        isDisplayed(requiredFieldError, Duration.ofSeconds(2));
    }

    public void isConfirmPasswordErrorDisplayed() {
        isDisplayed(passwordConfirmationError, Duration.ofSeconds(2));
    }

}
