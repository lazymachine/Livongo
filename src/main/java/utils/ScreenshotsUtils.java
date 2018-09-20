package main.java.utils;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import main.java.webdriver.DriverManager;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import static com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy.VERTICALLY;


public class ScreenshotsUtils {


    /**
     * takes a screenshot of the browser window.
     */
    public static void takeScreenshot() {
        try {

            String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HHmmss")
                    .format(Calendar.getInstance().getTime());

            String screenshotDir = System.getProperty("user.dir")
                    + File.separator + "target"
                    + File.separator + "surefire-reports"
                    + File.separator + "screenshots";

            File file = new File(screenshotDir);
            if (!file.exists()) {
                file.mkdir();
            }

            String fileName = "screenshot-" + timeStamp;

            Shutterbug.shootPage(DriverManager.driver, VERTICALLY, 500, true)
                    .withName(fileName).save(screenshotDir);

            String filePath = screenshotDir + File.separator + fileName;

            filePath = "screenshots" + File.separator
                    + filePath.substring(filePath.indexOf(fileName)) + ".png";

            Reporter.log("<img src=\"" + filePath + "\" width=\"35%\" />");

        } catch (Exception ex) {
            LogsUtils.logError(ex, "NOTE - Could not take screenshot\n");
        }
    }


}