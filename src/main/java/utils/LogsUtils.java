package main.java.utils;

import org.testng.Reporter;

public class LogsUtils {

    /**
     * log info
     */
    public static void log(String message) {
        Reporter.log(message, true);
    }

    /**
     * log info
     */
    public static void logError(Exception ex, String message) {

        Reporter.log("<font color='red'>"
                + "ERROR - " + message + " </font>", false);

        Reporter.log("ERROR - "
                + message, true);

        ex.printStackTrace();

    }

    /**
     * log info
     */
    public static void logError(String message) {

        Reporter.log("<font color='red'>"
                + "ERROR - " + message + " </font>", false);

        Reporter.log("ERROR - "
                + message, true);
    }


}