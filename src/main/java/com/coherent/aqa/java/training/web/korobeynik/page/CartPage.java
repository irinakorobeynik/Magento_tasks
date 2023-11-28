package com.coherent.aqa.java.training.web.korobeynik.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
        wait.waitForElementDisplayed(ShoppingCartHeader, Duration.ofSeconds(3));
    }

    @FindAll(@FindBy(how = How.CSS, using = ".product-item-name a"))
    private List<WebElement> cartItems;

    @FindBy(css = "td[data-th='Order Total'] span")
    private WebElement totalAmount;

    @FindBy(css = ".page-title span")
    private WebElement ShoppingCartHeader;

    @FindBy(css = ".action-delete")
    private WebElement deleteIcon;
    @FindBy(css = ".logo img")
    private WebElement logoIcon;

    public boolean doesAnyCartItemHaveText(String text){
        return cartItems.stream().anyMatch(element -> element.getText().contains(text));
    }

    public double getTotalFromCart(){
        wait.waitForElementDisplayed(totalAmount, Duration.ofSeconds(3));
        return parseDouble(totalAmount.getText().trim().replace("$", ""));
    }
    public boolean isDeleteIconDisplayed(){
       return isDisplayed(deleteIcon, Duration.ofSeconds(5));
    }

    public void deleteAllGoodsFromCart(){
        while (isDeleteIconDisplayed()){
            deleteIcon.click();
            driver.navigate().refresh();
        }
    }

    public PostLoginPage navigateToPostLoginPage(){
        logoIcon.click();
        return new PostLoginPage(driver);
    }


}
