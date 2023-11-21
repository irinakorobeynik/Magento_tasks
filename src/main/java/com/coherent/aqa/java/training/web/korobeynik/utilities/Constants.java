package com.coherent.aqa.java.training.web.korobeynik.utilities;


public class Constants {
    public static final String MAGENTO_URL = CommonUtils.getPropertyValue("magento.url");
    public static final String MAGENTO_USERNAME = CommonUtils.getPropertyValue("user.magento.username");
    public static final String MAGENTO_PASSWORD = CommonUtils.getPropertyValue("user.magento.password");
    public static final String MAGENTO_USERNAME_INCORRECT = CommonUtils.getPropertyValue("user.magento.username.incorrect");
    public static final String MAGENTO_PASSWORD_INCORRECT = CommonUtils.getPropertyValue("user.magento.password.incorrect");
    public static final String SIGN_OUT_LINK = CommonUtils.getPropertyValue("magento.logout");
    public static final String SCREENSHOT_PATH = CommonUtils.getPropertyValue("path.for.screenshots");
    public static final String BROWSER_NAME = CommonUtils.getPropertyValue("browser.name");
    public static final String REMOTE_URL = CommonUtils.getPropertyValue("remote.url");
}
