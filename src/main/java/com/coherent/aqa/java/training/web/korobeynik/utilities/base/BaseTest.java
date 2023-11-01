package com.coherent.aqa.java.training.web.korobeynik.utilities.base;

import com.coherent.aqa.java.training.web.korobeynik.utilities.driver.Driver;
import com.coherent.aqa.java.training.web.korobeynik.utilities.page.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.utils.Constants.MAGENTO_URL;

public class BaseTest {

    protected HomePage homePage;

    @BeforeClass
    public void openBrowser() {
        Driver.getDriver().get(MAGENTO_URL);
        homePage = new HomePage();
    }

    @AfterClass
    public static void closeBrowser() {
        Driver.tearDown();
    }
}
