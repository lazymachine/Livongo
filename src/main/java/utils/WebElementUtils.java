package main.java.utils;


import main.java.webdriver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementUtils {


    /**
     * click with webelement
     *
     * @param ele WebElement
     */
    public static void click(WebElement ele) {
        try {
            BrowserUtils.waitFor(ele, 10);
            JavaScriptUtils.scrollToObject(ele);
            BrowserUtils.waitForClickable(ele, 10);
            ele.click();
            JavaScriptUtils.waitForPageLoad();

        } catch (Exception e) {
            LogsUtils.logError(e, "Unable to click: " + ele.toString());
            ScreenshotsUtils.takeScreenshot();
        }

    }

    /**
     * waitFor method to poll page title
     *
     * @throws Exception
     */
    public static String getText(WebElement ele) {
        try {
            BrowserUtils.waitFor(ele, 10);
            JavaScriptUtils.scrollToObject(ele);
            return ele.getText();
        } catch (Exception e) {
            LogsUtils.logError(e,
                    "couldn't get text for web element: " + ele.toString());
            ScreenshotsUtils.takeScreenshot();
        }
        return "";

    }

    /**
     * click with webelement
     *
     * @param ele WebElement
     */
    public static void clearField(WebElement ele) {
        try {
            BrowserUtils.waitFor(ele, 10);
            JavaScriptUtils.scrollToObject(ele);
            BrowserUtils.waitForClickable(ele, 10);
            ele.click();
            ele.clear();
        } catch (Exception e) {
            LogsUtils.logError(e, "Unable to clear textbox: " + ele.toString());
            ScreenshotsUtils.takeScreenshot();
        }

    }


    /**
     * click with webelement
     *
     * @param ele WebElement
     */
    public static void fill(WebElement ele, String strInput) {
        try {
            clearField(ele);
            ele.sendKeys(strInput);
        } catch (Exception e) {
            LogsUtils.logError(e,
                    "Unable to fill textbox: " + ele.toString());
            ScreenshotsUtils.takeScreenshot();
        }

    }

    /**
     * choose Option by position.
     *
     * @param stateName to select
     */
    public static void selectDropDownState(WebElement ele, String stateName) {
        String options = ".//*[@ng-click='selectOption(match)']/span";

        try {
            BrowserUtils.waitFor(ele, 10);
            JavaScriptUtils.scrollToObject(ele);
            BrowserUtils.waitForClickable(ele, 10);

            ele.click();

            List<WebElement> optionsList = DriverManager.driver.findElements(By.xpath(options));

            for (int i = 0; i < optionsList.size(); i++) {
                if (optionsList.get(i).getText().equals(stateName)) {
                    WebElement webElement = optionsList.get(i);
                    BrowserUtils.waitForElement(webElement);
                    webElement.click();
                    BrowserUtils.waitForGone(webElement, 5);
                    break;
                }

            }


        } catch (Exception e) {
            LogsUtils.logError(e,
                    "Unable to select dropdown option:" + ele.toString() + " " + stateName);
            ScreenshotsUtils.takeScreenshot();
        }

    }

}
