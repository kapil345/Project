package com.plivo.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtil {

    public static Properties CONFIG = null;
    private static ConfigUtil ConfigUtil = new ConfigUtil();

    private ConfigUtil() {
        if (CONFIG == null) {
            CONFIG = new Properties();
            FileInputStream fs = null;
            try {
                if (System.getProperty("env").equals("staging") || System.getProperty("env") == null)
                    fs = new FileInputStream(PlivoConstants.STAGING_CONFIG_FILE_PATH);
                else
                    fs = new FileInputStream(PlivoConstants.PROD_CONFIG_FILE_PATH);
                CONFIG.load(fs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getDataFromConfig(String key) {
        try {
            return CONFIG.getProperty(key);
        } catch (Exception e) {
            LoggerUtils.error("Exception in get data from Config " + e.getMessage());
            return null;
        }
    }

}





