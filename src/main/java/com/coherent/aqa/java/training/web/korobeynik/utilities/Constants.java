package com.coherent.aqa.java.training.web.korobeynik.utilities;


public class Constants {
    public static final String MAGENTO_URL = CommonUtils.getPropertyValue("magento.url");
    public static final String MAGENTO_USERNAME = CommonUtils.getPropertyValue("user.magento.username");
    public static final String MAGENTO_PASSWORD = CommonUtils.getPropertyValue("user.magento.password");
    public  static final String MAGENTO_NEW_ACCOUNT_EMAIL =CommonUtils.setPropertyValue("magento.new.account",
            CommonUtils.getRandomString(6) +"@gmail.com");
    public static final String MAGENTO_FIRSTNAME = CommonUtils.setPropertyValue("magento.firstname", CommonUtils.getRandomString(10));
    public static final String MAGENTO_LASTNAME = CommonUtils.setPropertyValue("magento.lastname", CommonUtils.getRandomString(10));
    public static final String WRONG_CONFIRM_PASSWORD = CommonUtils.setPropertyValue("magento.wrong.password", CommonUtils.getRandomString(10));
    public static final String SIGN_OUT_LINK = CommonUtils.getPropertyValue("magento.logout");
    public static final String SCREENSHOT_PATH = CommonUtils.getPropertyValue("path.for.screenshots");
    public static final String BROWSER_NAME = CommonUtils.getPropertyValue("browser.name");
    public static final String BROWSER_VERSION = CommonUtils.getPropertyValue("browser.version");
    public static final String REMOTE_URL = CommonUtils.getPropertyValue("remote.url");
    public static final String SAUCE_USERNAME = CommonUtils.getPropertyValue("sauce.username");
    public static final String SAUCE_ACCESS_KEY = CommonUtils.getPropertyValue("sauce.accessKey");
    public static final String SAUCE_PLATFORM = CommonUtils.getPropertyValue("platform.name");

}
