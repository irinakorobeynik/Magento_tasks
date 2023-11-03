package com.coherent.aqa.java.training.web.korobeynik.base;

import com.coherent.aqa.java.training.web.korobeynik.driver.Driver;
import com.coherent.aqa.java.training.web.korobeynik.page.HomePage;
import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.MAGENTO_URL;

public class BaseTest {
    protected WebDriver driver;
    protected WaiterUtils wait;

    protected HomePage homePage;

    @BeforeMethod
    public void openBrowser() {
        driver =Driver.getDriver();
        driver.get(MAGENTO_URL);
        wait = new WaiterUtils(driver);
        homePage = new HomePage(driver,wait);

    }

    @AfterMethod
    public void closeBrowser() {
        Driver.tearDown();
    }
}
