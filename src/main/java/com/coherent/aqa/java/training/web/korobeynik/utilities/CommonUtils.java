package com.coherent.aqa.java.training.web.korobeynik.utilities;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.reporters.jq.Main;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CommonUtils {
    public static String getPropertyValue(String property) {
        String value = null;
        try {
            PropertiesConfiguration conf = new PropertiesConfiguration("src/main/resources/config.properties");
            value = (String) conf.getProperty(property);
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    public static String setPropertyValue(String key, String property) {
        try {
            PropertiesConfiguration conf = new PropertiesConfiguration("src/main/resources/config.properties");
            conf.setProperty(key, property);
            conf.save();
        } catch (NullPointerException |ConfigurationException e) {
            throw new RuntimeException("Something wrong with setting values for testing: " + e);
        }
        return property;
    }

    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

}
