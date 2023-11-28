package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.driver.Driver;
import com.coherent.aqa.java.training.web.korobeynik.goods.Goods;
import com.coherent.aqa.java.training.web.korobeynik.page.CartPage;
import com.coherent.aqa.java.training.web.korobeynik.page.LoginPage;
import com.coherent.aqa.java.training.web.korobeynik.page.NewGoodsPage;
import com.coherent.aqa.java.training.web.korobeynik.page.PostLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.MAGENTO_PASSWORD;
import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.MAGENTO_USERNAME;

public class CartTest extends BaseTest{
    private LoginPage loginPage;
    private PostLoginPage postLoginPage;
    private NewGoodsPage newGoodsPage;
    private CartPage cartPage;

    @BeforeMethod
    public void openHomePage() {
        loginPage = homePage.navigateToLoginPage();
        loginPage.enterUsername(MAGENTO_USERNAME);
        loginPage.enterPassword(MAGENTO_PASSWORD);
        postLoginPage = loginPage.loginToApp();
        newGoodsPage = postLoginPage.openNewGoodsPage();
    }

    @Test
    public void getGoodsToTheCart(){
        List<Goods> goodsList =newGoodsPage.getThreeGoodsToCart();
        cartPage = newGoodsPage.navigateToCart();
        SoftAssert softAssert = new SoftAssert();
        goodsList.forEach(good -> {
            softAssert.assertTrue(cartPage.doesAnyCartItemHaveText(good.getName()), "No matches with goods added to the Cart found");
        });
        softAssert.assertTrue(cartPage.getTotalFromCart()>= Goods.getTotal(), "Total less than expected");
        softAssert.assertAll("Something goes wrong with Goods adding to the cart");
    }

    @AfterMethod
    public void deleteAllFromCart(){
        cartPage.deleteAllGoodsFromCart();
        Driver.tearDown();
    }
}
