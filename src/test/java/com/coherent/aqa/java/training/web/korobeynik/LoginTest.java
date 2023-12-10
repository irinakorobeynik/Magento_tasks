package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.page.LoginPage;
import com.coherent.aqa.java.training.web.korobeynik.page.PostLoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.MAGENTO_PASSWORD;
import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.MAGENTO_USERNAME;


@Feature("Login functionality")
public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private PostLoginPage postLoginPage;

    @BeforeClass
    public void openHomePage() {
        loginPage = homePage.navigateToLoginPage();
    }

    @Test
    @TmsLink("114")
    @Description("Login test with valid credentials")
    public void loginTest() {
        loginPage.enterUsername(MAGENTO_USERNAME);
        loginPage.enterPassword(MAGENTO_PASSWORD);
        postLoginPage = loginPage.loginToApp();
        Assert.assertTrue(postLoginPage.isGreetingDisplayed(), "Logging in failed");
    }

}

