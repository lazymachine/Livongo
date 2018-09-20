package main.java.utils;


import main.java.webdriver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static main.java.webdriver.DriverManager.wait;


/**
 * Selenium JavaScript Executor Utility Class *
 */
public class JavaScriptUtils {

    private static WebDriver driver = DriverManager.driver;

    // constructor
    public JavaScriptUtils() {

    }


    /**
     * Waits for the page to finish loading.
     *
     * @return true if successful, otherwise false
     */
    public static boolean waitForPageLoad() {
        if (waitForJsNotActive(wait, driver)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Waits for the page to finish loading.
     *
     * @param wait time to wait
     * @return true if successful, otherwise false
     */
    public static boolean waitForJsNotActive(WebDriverWait wait, WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String isjqueryPresent = js
                    .executeScript("return (typeof jQuery != 'undefined');").toString();

            String condition = "";
            switch (isjqueryPresent) {
                case "true":
                    condition = "return (document.readyState == 'complete' && "
                            + "jQuery(':animated').length == 0 && jQuery.active == 0)";
                    break;
                case "false":
                    condition = "return (document.readyState == 'complete')";
                    break;
                default:
                    break;
            }

            wait.until(ExpectedConditions.jsReturnsValue(condition));

            return true;
        } catch (Exception ex) {
            // If document.readyState is complete then don't log as error.
            // Sometimes jQuery stays active but is not a blocker
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (js.executeScript("return document.readyState").equals("complete")
                    || js.executeScript("return document.readyState").equals("interactive")) {
                LogsUtils.logError(ex, "NOTE - readyState is complete - jQuery is still active or not present");
                return true;
            } else {
                LogsUtils.logError(ex, "readyState - "
                        + js.executeScript("return document.readyState"));
                LogsUtils.logError(ex, "jquery animated - "
                        + js.executeScript("return jQuery(':animated').length"));
                LogsUtils.logError(ex, "jQuery active - "
                        + js.executeScript("return jQuery.active"));
                return false;
            }
        }
    }


    /**
     * Scrolls to the inputedObject and puts the object into view.
     */
    public static void scrollToObject(WebElement element) {
        BrowserUtils.waitForElement(element);
        if (!FileInOutUtils.getConfig().getProperty("browser")
                .toLowerCase().contains("Firefox")) {
            String scrollElementIntoMiddle = "var viewPortHeight = "
                    + "Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                    + "var elementTop = arguments[0].getBoundingClientRect().top;"
                    + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

            ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

        } else {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(" + "top" + ");", element);
        }
    }

}