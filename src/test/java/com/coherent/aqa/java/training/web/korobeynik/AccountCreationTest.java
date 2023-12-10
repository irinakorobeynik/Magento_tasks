package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.page.AccountPage;
import com.coherent.aqa.java.training.web.korobeynik.page.CreateAccountPage;
import com.coherent.aqa.java.training.web.korobeynik.utilities.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Feature("Account Creation functionality")
public class AccountCreationTest extends BaseTest {

    private CreateAccountPage createAccountPage;
    private AccountPage accountPage;

    @BeforeClass
    public void openHomePage() {
        createAccountPage = homePage.navigateToCreateAccountPage();
    }

    @Test
    @TmsLink("111")
    @Description("Account creation")
    public void accountCreationTest() {
        createAccountPage.enterFirstName(Constants.MAGENTO_FIRSTNAME);
        createAccountPage.enterLastName(Constants.MAGENTO_LASTNAME);
        createAccountPage.enterEmail(Constants.MAGENTO_NEW_ACCOUNT_EMAIL);
        createAccountPage.enterPassword(Constants.MAGENTO_PASSWORD);
        createAccountPage.confirmPassword(Constants.MAGENTO_PASSWORD);
        accountPage = createAccountPage.clickCreateAccountButtonWithFilledFields();
        Assert.assertTrue(accountPage.isAccountCreationTextDisplayed(), "Account is not created");
    }

}
