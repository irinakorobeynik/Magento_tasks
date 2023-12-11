package com.coherent.aqa.java.training.web.korobeynik.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class WishListPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(),'My Wish List')]")
    private WebElement wishListHeader;

    @FindBy(css = ".products-grid.wishlist")
    private WebElement wishListContent;


    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWishListHeaderDisplayed(){
        return isDisplayed(wishListHeader, Duration.ofSeconds(5));
    }

    public boolean isWishListContentDisplayed(){
        return isDisplayed(wishListContent, Duration.ofSeconds(5));
    }
}
