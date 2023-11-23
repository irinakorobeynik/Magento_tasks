package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.page.AccountPage;
import com.coherent.aqa.java.training.web.korobeynik.page.CreateAccountPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;

//@Listeners(TestListener.class)
@Feature("Account Creation functionality")
public class AccountCreationTest extends BaseTest {

    private CreateAccountPage createAccountPage;
    private AccountPage accountPage;

    @BeforeMethod
    public void openHomePage() {
        createAccountPage = homePage.navigateToCreateAccountPage();
    }


    @Test
    @TmsLink("113")
    @Description("Account creation")
    public void accountCreationTest() {
        createAccountPage.enterFirstName(MAGENTO_FIRSTNAME);
        createAccountPage.enterLastName(MAGENTO_LASTNAME);
        createAccountPage.enterEmail(MAGENTO_NEW_ACCOUNT_EMAIL);
        createAccountPage.enterPassword(MAGENTO_PASSWORD);
        createAccountPage.confirmPassword(MAGENTO_PASSWORD);
        accountPage = createAccountPage.clickCreateAccountButtonWithFilledFields();
        Assert.assertTrue(accountPage.isAccountCreationTextDisplayed(), "Account is not created");

    }


}
