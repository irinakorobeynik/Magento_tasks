package com.coherent.aqa.java.training.web.korobeynik.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AddressPage extends BasePage {

    @FindBy(css = "#street_1")
    private WebElement streetInput;
    @FindBy(xpath = "//span[contains(text(),'Add New Address')]")
    private WebElement addNewAddress;

    @FindBy(xpath = "//div[contains(text(),'This is a required field.')]")
    private WebElement requiredFieldError;

    @FindBy(xpath = "//div[contains(text(),'Please select an option.')]")
    private WebElement selectOptionError;

    @FindBy(id = "telephone")
    private WebElement phoneInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "region_id")
    private WebElement regionInput;

    @FindBy(id = "country")
    private WebElement countryInput;

    @FindBy(id = "zip")
    private WebElement zipInput;

    @FindBy(id = "primary_billing")
    private WebElement useAsDefaultBillingAddressCheckbox;

    @FindBy(css = ".action.save.primary")
    private WebElement saveAddressButton;

    @FindBy(css = ".box-address-billing address")
    private WebElement address;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public boolean isStreetInoutDisplayed() {

        return isDisplayed(streetInput, Duration.ofSeconds(3));
    }

    public boolean isBillingCheckboxDisplayed() {
        return isDisplayed(useAsDefaultBillingAddressCheckbox, Duration.ofSeconds(3));
    }

    public void enterStreetAddress(String values) {
        if (!isStreetInoutDisplayed()) addNewAddress.click();
        streetInput.sendKeys(values);
    }

    public void selectCountry(String country) {
        Select select = new Select(countryInput);
        if (country.equals("any")) {
            List<WebElement> options = countryInput.findElements(By.xpath(".//option"))
                    .stream()
                    .toList();
            select.selectByIndex(new Random().nextInt((options.size() - 1) + 1) + 1);

        } else {
            select.selectByVisibleText(country);
        }
    }

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterZip(String zip) {
        zipInput.sendKeys(zip);
    }

    public void saveAddress() {
        if (isBillingCheckboxDisplayed()) useAsDefaultBillingAddressCheckbox.click();
        saveAddressButton.click();

    }

    public boolean isBillingAddressDisplayed(){
        return isDisplayed(address,Duration.ofSeconds(3));
    }

    public boolean doesAddressContains(String text){
        return doesElementContainsText(address,text);
    }


}
