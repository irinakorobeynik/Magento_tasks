package com.coherent.aqa.java.training.web.korobeynik.utilities;


import com.coherent.aqa.java.training.web.korobeynik.utilities.CommonUtils;

public class Constants {
    public static final String MAGENTO_URL = CommonUtils.getPropertyValue("magento.url");
    public static final String MAGENTO_USERNAME = CommonUtils.getPropertyValue("user.magento.username");
    public static final String MAGENTO_PASSWORD = CommonUtils.getPropertyValue("user.magento.password");
    public static final String SIGN_OUT_LINK = CommonUtils.getPropertyValue("magento.logout");
}
