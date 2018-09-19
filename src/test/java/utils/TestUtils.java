package test.java.utils;

import org.testng.Reporter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestUtils {


    /**
     * Appends the log file with the input string.
     *
     * @param text String to add to the log file
     */
    public void log(String text) {
        String date = new SimpleDateFormat("HH.mm.sss").format(new Date());
        Reporter.log(date + "\t" + text, true);
    }

    /**
     * Appends the log file with the input string.
     *
     * @param text String to add to the log file
     */
    public void logError(String text) {
        String date = new SimpleDateFormat("HH.mm.sss").format(new Date());
        Reporter.log(date + "\t" + "<font color='red'>" + text + "</font>", true);

    }

    /**
     * Generates unique email for test input.
     */
    public String createUniqueEmail() {
        String timeStamp = new SimpleDateFormat("MM_dd_HHmmss").format(Calendar.getInstance().getTime());

        String email = "sbaral+" + timeStamp + "@gmail.com";
        return email;
    }

    /**
     * Sleeps for a given amount of time.
     *
     * @param timeInSec Time to pause
     */
    public void pause(int timeInSec) {
        try {
            Thread.sleep(timeInSec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
