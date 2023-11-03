package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.page.HomePage;
import com.coherent.aqa.java.training.web.korobeynik.driver.Driver;
import com.coherent.aqa.java.training.web.korobeynik.utilities.Constants;
import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected WaiterUtils wait;
    protected HomePage homePage;

    @BeforeMethod
    public void openBrowser() {
        driver = Driver.getInstance();
        driver.get(Constants.MAGENTO_URL);
        wait = WaiterUtils.getInstance(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
       Driver.tearDown();

    }
}
