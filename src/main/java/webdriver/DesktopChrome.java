package main.java.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.utils.BrowserUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class DesktopChrome extends DriverManager {

  @Override
  public void createDriver() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("disable-infobars");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--privileged");
    chromeOptions.addArguments("--start-maximized");

    LoggingPreferences logs = new LoggingPreferences();
    logs.enable(LogType.BROWSER, Level.ALL);
    chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logs);

    Map<String, Object> prefs = new HashMap<>();
    prefs.put("credentials_enable_service", false);
    prefs.put("profile.password_manager_enabled", false);
    chromeOptions.setExperimentalOption("prefs", prefs);

    super.driver = new ChromeDriver(chromeOptions);
    BrowserUtils.maximizeScreen(driver);
    super.driver.manage().window().maximize();
    super.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

  }

}
