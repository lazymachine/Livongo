package main.java.utils;


import com.google.common.base.Function;
import main.java.webdriver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.Dimension;
import java.time.Duration;


public class BrowserUtils {

    static WebDriver driver = DriverManager.driver;


    /**
     * waitFor method to wait up to a designated period before
     * * throwing exception (static locator)
     *
     * @param element
     * @param timer
     */
    public static void waitFor(WebElement element, int timer) {
        // wait for the static element to appear
        WebDriverWait exists = new WebDriverWait(driver, timer);
        exists.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(element)));
    }


    /**
     * waitForClickable method to poll for clickable
     *
     * @param ele
     * @param timer
     */
    public static void waitForClickable(WebElement ele, int timer) {
        WebDriverWait exists = new WebDriverWait(driver, timer);
        exists.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(ele)));
    }

    /**
     * waitForGone method to wait up to a designated period before
     * * throwing exception if element still exists
     *
     * @param ele
     * @param timer
     */
    public static void waitForGone(WebElement ele, int timer) {
        // wait for the dynamic element to disappear
        WebDriverWait exists = new WebDriverWait(driver, timer);
        exists.until(ExpectedConditions.refreshed(
                ExpectedConditions.invisibilityOf(ele)));

    }


    /**
     * Maximizes the browser window.
     */
    public static void maximizeScreen(WebDriver driver) {
        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Point position = new Point(0, 0);
            driver.manage().window().setPosition(position);
            org.openqa.selenium.Dimension maximizedScreenSize
                    = new org.openqa.selenium.Dimension((int) screenSize.getWidth(),
                    (int) screenSize.getHeight());
            driver.manage().window().setSize(maximizedScreenSize);
        } catch (Exception e) {
            LogsUtils.logError(e, "maximizeScreen\n");
            ScreenshotsUtils.takeScreenshot();
        }
    }

    /**
     * Moves mouse to origin.
     */
    public static void moveMouseToOrigin() {

        // Move cursor to top left
        try {
            Robot robot = new Robot();
            robot.mouseMove(0, 0);
        } catch (AWTException e) {
            LogsUtils.log("ERROR - robot not able to move cursor. -__-");
        }

    }


    /**
     * getElementWithFluentWait mentioned seconds.
     *
     * @param xpath               xPath
     * @param intervalMiliseconds sec
     * @param maxSecondsToWait    sec
     * @return boolean
     */
    public static WebElement getElementWithFluentWait(final String xpath,
                                                      final int intervalMiliseconds,
                                                      final int maxSecondsToWait) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxSecondsToWait))
                .pollingEvery(Duration.ofMillis(intervalMiliseconds))
                .ignoring(NoSuchElementException.class);

        return wait.until((Function<WebDriver, WebElement>) webDriver
                -> webDriver.findElement(By.xpath(xpath)));
    }

    /**
     * Waits for an element to be displayed. 35 second wait with 1 second intervals.
     *
     * @return true if element is displayed, false if not
     */
    public static boolean waitForElement(WebElement element) {
        Wait<WebDriver> waitForElement
                = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

        boolean objectFound = waitForElement.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return element.isDisplayed();
                } catch (Exception ex) {
                    return false;
                }
            }
        });
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavaScriptUtils.waitForJsNotActive(wait, driver);
        return objectFound;
    }


}
