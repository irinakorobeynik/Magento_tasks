package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.utilities.base.BaseTest;
import com.coherent.aqa.java.training.web.korobeynik.utilities.page.LoginPage;
import com.coherent.aqa.java.training.web.korobeynik.utilities.page.PostLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.utils.Constants.*;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private PostLoginPage postLoginPage;

    @BeforeClass
    public void openHomePage() {
        loginPage = homePage.navigateToLoginPage();
    }

    @Test
    public void loginTest() {
        loginPage.enterUsername(MAGENTO_USERNAME);
        loginPage.enterPassword(MAGENTO_PASSWORD);
        postLoginPage = loginPage.loginToApp();
        Assert.assertTrue(postLoginPage.isGreetingDisplayed(), "Logging in failed");
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}

