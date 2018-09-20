package main.java.utils;

import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtils {

    /**
     * Loads the config properties file.
     *
     * @return returns the config file
     */
    public static Properties getConfig() {

        String filePath = System.getProperty("user.dir")
                + File.separator + "config.properties";

        return loadPropertiesHelper(filePath);
    }


    /**
     * Loads the properties file.
     *
     * @return returns the properties file
     */
    public static Properties loadPropertiesHelper(String fileLocation) {
        Properties prop = new Properties();

        InputStream input = null;

        try {

            input = new FileInputStream(fileLocation);
            prop.load(input);

        } catch (Exception ex) {
            Reporter.log("Failed to load properties file", true);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception ex) {
                    Reporter.log(ex.getMessage(), true);
                }
            }
        }
        return prop;
    }
}
