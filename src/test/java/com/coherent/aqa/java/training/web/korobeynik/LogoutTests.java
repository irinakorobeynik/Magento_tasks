package com.coherent.aqa.java.training.web.korobeynik;


import com.coherent.aqa.java.training.web.korobeynik.page.LoginPage;
import com.coherent.aqa.java.training.web.korobeynik.page.LogoutPage;
import com.coherent.aqa.java.training.web.korobeynik.page.PostLoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;

public class LogoutTests extends BaseTest {
    private LoginPage loginPage;
    private PostLoginPage postLoginPage;
    private LogoutPage logoutPage;

    @BeforeMethod
    public void openHomePage() {
        loginPage = homePage.navigateToLoginPage();
        loginPage.enterUsername(MAGENTO_USERNAME);
        loginPage.enterPassword(MAGENTO_PASSWORD);
        postLoginPage = loginPage.loginToApp();
    }

    @Test
    public void logoutTest() {
        postLoginPage.openMenu();
        logoutPage = postLoginPage.logout();
        Assert.assertTrue(logoutPage.isSignOutTextDisplayed(), "Sign Out text is not displayed");
        Assert.assertEquals(logoutPage.getLogOutPage(), SIGN_OUT_LINK, "Sing Out failed");

    }

}
