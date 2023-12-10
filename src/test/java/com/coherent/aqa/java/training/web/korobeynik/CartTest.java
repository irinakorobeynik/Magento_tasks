package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.driver.Driver;
import com.coherent.aqa.java.training.web.korobeynik.goods.Goods;
import com.coherent.aqa.java.training.web.korobeynik.page.CartPage;
import com.coherent.aqa.java.training.web.korobeynik.page.LoginPage;
import com.coherent.aqa.java.training.web.korobeynik.page.NewGoodsPage;
import com.coherent.aqa.java.training.web.korobeynik.page.PostLoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.MAGENTO_PASSWORD;
import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.MAGENTO_USERNAME;

@Feature("Adding  Goods to cart")
public class CartTest extends BaseTest {
    private LoginPage loginPage;
    private PostLoginPage postLoginPage;
    private NewGoodsPage newGoodsPage;
    private CartPage cartPage;

    @BeforeClass
    public void openHomePage() {
        loginPage = homePage.navigateToLoginPage();
        loginPage.enterUsername(MAGENTO_USERNAME);
        loginPage.enterPassword(MAGENTO_PASSWORD);
        postLoginPage = loginPage.loginToApp();
        newGoodsPage = postLoginPage.openNewGoodsPage();
    }

    @Test
    @TmsLink("113")
    @Description("Adding to Cart")
    public void getGoodsToTheCart() {
        List<Goods> goodsList = newGoodsPage.getThreeGoodsToCart();
        cartPage = newGoodsPage.navigateToCart();
        SoftAssert softAssert = new SoftAssert();
        goodsList.forEach(good -> {
            softAssert.assertTrue(cartPage.doesAnyCartItemHaveText(good.getName()), "No matches with goods added to the Cart found");
        });
        softAssert.assertTrue(cartPage.getTotalFromCart() >= Goods.getTotal(), "Total less than expected");
        softAssert.assertAll("Something goes wrong with Goods adding to the cart");
    }

    @AfterClass
    public void deleteAllFromCart() {
        cartPage.deleteAllGoodsFromCart();
        Driver.tearDown();
    }
}
