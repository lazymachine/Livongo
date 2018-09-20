package main.java.utils;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.HashMap;
import java.util.Properties;

public class TestUtils {

    public static String DATA_FILE;


    /**
     * Generates unique email for test input.
     */
    public String createUniqueEmail() {
        String timeStamp = new SimpleDateFormat("MM_dd_HHmmss").format(Calendar.getInstance().getTime());

        String email = "sbaral+" + timeStamp + "@gmail.com";
        return email;
    }

    /**
     *
     */
    public static HashMap<String, String> loadTestDataInput() {

        String path_to_testdata_properties
                = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "java"
                + File.separator + "_resources"
                + File.separator + "testData";


        Properties properties = FileInOutUtils
                .readPropertyFile(path_to_testdata_properties
                        + File.separator + DATA_FILE);

        HashMap<String, String> testdatamap = new HashMap<>();

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            testdatamap.put(key, value);
        }
        return testdatamap;
    }
}
