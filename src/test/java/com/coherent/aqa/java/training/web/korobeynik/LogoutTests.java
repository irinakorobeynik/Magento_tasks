package com.coherent.aqa.java.training.web.korobeynik;


import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BaseTest;
import com.coherent.aqa.java.training.web.korobeynik.utilities.page.LoginPage;
import com.coherent.aqa.java.training.web.korobeynik.utilities.page.LogoutPage;
import com.coherent.aqa.java.training.web.korobeynik.utilities.page.PostLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.utils.Constants.*;

public class LogoutTests extends BaseTest {
    private LoginPage loginPage;
    private PostLoginPage postLoginPage;
    private LogoutPage logoutPage;

    @BeforeClass
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

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}
