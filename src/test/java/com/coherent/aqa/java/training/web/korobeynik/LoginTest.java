package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.base.BaseTest;
import com.coherent.aqa.java.training.web.korobeynik.page.LoginPage;
import com.coherent.aqa.java.training.web.korobeynik.page.PostLoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
   private PostLoginPage postLoginPage;

    @BeforeMethod
    public void openHomePage() {
        loginPage = homePage.navigateToLoginPage();
    }
    @Test
    public void loginTest(){
        loginPage.enterUsername(MAGENTO_USERNAME);
        loginPage.enterPassword(MAGENTO_PASSWORD);
        postLoginPage = loginPage.loginToApp();
        Assert.assertTrue(postLoginPage.isGreetingDisplayed(), "Logging in failed");
    }

    @AfterMethod
    public void tearDown() {
       closeBrowser();
    }
}

