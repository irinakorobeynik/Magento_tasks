package com.coherent.aqa.java.training.web.korobeynik;


import com.coherent.aqa.java.training.web.korobeynik.page.LoginPage;
import com.coherent.aqa.java.training.web.korobeynik.page.PostLoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import io.qameta.allure.TmsLink;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
@Feature("Login functionality")
public class LoginTest extends BaseTest {
    private LoginPage loginPage;
   private PostLoginPage postLoginPage;

    @BeforeMethod
    public void openHomePage() {
        loginPage = homePage.navigateToLoginPage();
    }
    @Test(dataProvider = "credentialsDataProvider", dataProviderClass = BaseTest.class)
    @TmsLink("111")
    @Description("Login test with several credentials")
    public void loginTest(String username, String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        postLoginPage = loginPage.loginToApp();
        Assert.assertTrue(postLoginPage.isGreetingDisplayed(), "Logging in failed");
    }

}

