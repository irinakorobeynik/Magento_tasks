package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.page.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.MAGENTO_PASSWORD;
import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.MAGENTO_USERNAME;

public class WishListTest extends BaseTest{

    private LoginPage loginPage;
    private PostLoginPage postLoginPage;
    private NewGoodsPage newGoodsPage;

    private WishListPage wishListPage;

    @BeforeMethod
    public void openHomePage() {
        loginPage = homePage.navigateToLoginPage();
        loginPage.enterUsername(MAGENTO_USERNAME);
        loginPage.enterPassword(MAGENTO_PASSWORD);
        postLoginPage = loginPage.loginToApp();
        newGoodsPage = postLoginPage.openNewGoodsPage();
    }

    @Test
    public void addToWishList(){
        newGoodsPage.hoverOverFistGoodItem();
        wishListPage = newGoodsPage.addToWishList();
        Assert.assertTrue(wishListPage.isWishListContentDisplayed(), "Wish List Content is not displayed");
        Assert.assertTrue(wishListPage.isWishListHeaderDisplayed(), "Wish List Header is not displayed");

    }



}
