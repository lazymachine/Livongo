package main.java;

import main.java.utils.LogsUtils;
import main.java.webdriver.DriverManager;
import org.openqa.selenium.*;
import main.java.utils.TestUtils;

import java.util.HashMap;
import java.util.Map;


public abstract class BasePage {

    public TestUtils utils = new TestUtils();

    protected WebDriver driver;
    protected String driverOriginalHandle;

    protected static HashMap<String, String> testdataInput = initTestData();

    /**
     * Class Constructor.
     */
    public BasePage() {
        this.driver = DriverManager.driver;

        this.driverOriginalHandle = DriverManager.driverOriginalHandle;

    }

    protected void log(String message) {
        LogsUtils.log(message);
    }

    protected void logError(Exception ex, String message) {
        LogsUtils.logError(ex, message);
    }

    /**
     * helper method for initializing testdata.
     */
    public static HashMap<String, String> initTestData() {
        HashMap<String, String> _testdataInput = null;
        if (TestUtils.loadTestDataInput() != null) {
            _testdataInput = TestUtils.loadTestDataInput();
            LogsUtils.log("test data fileName: " + TestUtils.DATA_FILE);

            String data = "";
            for (Map.Entry<String, String> entry : _testdataInput.entrySet()) {
                data += "(" + entry.getKey() + " : " + entry.getValue() + "),";
            }
            LogsUtils.log("[" + data.substring(0, data.lastIndexOf("),")) + "]");
        } else {
            LogsUtils.log("*** Warning No Test data loaded *****");
        }
        return _testdataInput;
    }

    /**
     * function to get method name.
     */
    protected static String getMethodName() {
        //method name
        return Thread.currentThread()
                .getStackTrace()[2].getMethodName();
    }

}
