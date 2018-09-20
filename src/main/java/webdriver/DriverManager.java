package main.java.webdriver;

import main.java.utils.BrowserUtils;
import main.java.utils.FileInOutUtils;
import main.java.utils.LogsUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public abstract class DriverManager {

  // local variables

  protected static final int IMPLICIT_TIMEOUT = 60;
  protected static final int DRIVER_WAIT = 15;

  public static WebDriver driver;
  public static WebDriverWait wait;

  public static String driverOriginalHandle;

  protected abstract void createDriver();

  public WebDriver getDriver() {
    if (null == this.driver) {
      createDriver();
    }
    this.driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    // set wait timeout
    this.wait = new WebDriverWait(driver, DRIVER_WAIT);


    this.driverOriginalHandle = driver.getWindowHandle();

    BrowserUtils.moveMouseToOrigin();

    return this.driver;
  }



}
