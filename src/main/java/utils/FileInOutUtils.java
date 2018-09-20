package main.java.utils;

import java.io.*;
import java.util.Properties;

public class FileInOutUtils {

    private static Properties prop;
    private static InputStream input = null;


    /**
     * Loads the config properties file.
     *
     * @return returns the config file
     */
    public static Properties getConfig() {
        Properties prop = new Properties();

        InputStream input = null;

        try {
            String configLocation = (System.getProperty("user.dir")
                    + File.separator + "config.properties");

            input = new FileInputStream(configLocation);

            prop.load(input);

        } catch (Exception ex) {
            LogsUtils.logError(ex, "Failed to load config properties file\n");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception ex) {
                    LogsUtils.logError(ex, "Failed to close config properties\n");
                }
            }
        }
        return prop;
    }

    /**
     * TODO.
     *
     * @param filePath ---
     */
    public static Properties readPropertyFile(String filePath) {

        prop = new Properties();
        try {

            if (!filePath.contains(".properties")) {
                input = new FileInputStream(filePath + ".properties");
            } else {
                input = new FileInputStream(filePath);
            }

            // load a properties file
            prop.load(input);

        } catch (IOException ex) {
            LogsUtils.logError(ex, "unable read property file: " + filePath);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception ex) {
                    LogsUtils.logError(ex, "Failed to close  properties\n");
                }
            }
            return prop;
        }
    }


}