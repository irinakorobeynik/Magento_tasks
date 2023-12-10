package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.page.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;

@Feature("Account details filling in")
public class AddingAddressTest extends BaseTest {
    private LoginPage loginPage;
    private PostLoginPage postLoginPage;
    private AccountPage accountPage;
    private AddressPage addressPage;

    @BeforeClass
    public void openHomePage() {
        loginPage = homePage.navigateToLoginPage();
        loginPage.enterUsername("KEkWXm@gmail.com");
        loginPage.enterPassword(MAGENTO_PASSWORD);
        postLoginPage = loginPage.loginToApp();
        postLoginPage.openMenu();
        accountPage = postLoginPage.openAccountPage();
        addressPage = accountPage.navigateToAddressPage();
    }

    @Test
    @TmsLink("112")
    @Description("Adding Address")
    public void addingAddressTest() {
        addressPage.enterStreetAddress("asdasdasd");
        addressPage.enterPhone("123");
        addressPage.enterCity("asd");
        addressPage.enterZip("123");
        addressPage.selectCountry("any");
        addressPage.saveAddress();
        SoftAssert asert = new SoftAssert();
        asert.assertTrue(addressPage.isBillingAddressDisplayed(), "Address is not displayed");
        asert.assertTrue(addressPage.doesAddressContains("123"), "Address is wrong");
        asert.assertAll("Something went wrong with Address adding");
    }
}
