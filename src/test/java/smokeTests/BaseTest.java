package test.java.smokeTests;

import main.java.utils.LogsUtils;
import main.java.webdriver.DriverManager;
import main.java.webdriver.DriverManagerFactory;
import org.openqa.selenium.WebDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import main.java.utils.TestUtils;


public abstract class BaseTest {

    private DriverManager driverManager;
    protected String environment;

    protected WebDriver driver;

    public TestUtils utils = new TestUtils();


    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        Reporter.log("-------------------------------Executing test: "
                + this.getClass().getSimpleName() + "-------------------------------", true);
        // create driver
        driverManager = DriverManagerFactory.getManager();
        driverManager.getDriver();

        this.driver = DriverManager.driver;

        LogsUtils.log("\n*** TEST ENVIRONMENT = "
                + "/" + environment
                + "/Session ID="
                + driver.toString().split(" \\(")[1].replace(")", "")
                + "\n");

        LogsUtils.log("====================Executing Test Class: "
                + this.getClass().getSimpleName() + "======================");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) driver.quit();
        Reporter.log("-------------End of Test-------------------------" +
                "-------------------------------------\n", true);
    }


}
