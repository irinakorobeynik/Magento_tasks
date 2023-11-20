package com.coherent.aqa.java.training.web.korobeynik;

import com.coherent.aqa.java.training.web.korobeynik.driver.Driver;
import com.coherent.aqa.java.training.web.korobeynik.driver.DriverOptions;
import com.coherent.aqa.java.training.web.korobeynik.page.HomePage;
import com.coherent.aqa.java.training.web.korobeynik.screenshot.ScreenShot;
import com.coherent.aqa.java.training.web.korobeynik.utilities.CommonUtils;
import com.coherent.aqa.java.training.web.korobeynik.waiter.WaiterUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.coherent.aqa.java.training.web.korobeynik.utilities.Constants.*;

public class BaseTest {

    protected WebDriver driver;
    protected WaiterUtils wait;
    protected ScreenShot screenShot;
    protected HomePage homePage;

    @BeforeMethod
    public void openBrowser()  {
        driver = Driver.getDriver().openRemoteDriver(DriverOptions.CHROME);
        driver.get(MAGENTO_URL);
        wait = WaiterUtils.getInstance(driver);
        screenShot = ScreenShot.getInstance(driver);
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void closeBrowser() {
        Driver.tearDown();
    }

    @DataProvider(name = "credentialsDataProvider")
    public static Object[][] credentialsDataProvider() {
        return new Object[][]{
                {MAGENTO_USERNAME, MAGENTO_PASSWORD},
                {MAGENTO_USERNAME_INCORRECT, MAGENTO_PASSWORD_INCORRECT}
        };
    }

}



