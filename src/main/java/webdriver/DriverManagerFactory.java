package main.java.webdriver;


import main.java.utils.FileInOutUtils;

public class DriverManagerFactory {


    /**
     * getInstance method to retrieve active driver instance.
     *
     * @return DriverManagerFactory
     */
    public static DriverManager getManager() {

        DriverManager driverManager = null;

        String browserType
                = FileInOutUtils.getConfig().getProperty("browser");

        switch (browserType) {

            case "CHROME":
                driverManager = new DesktopChrome();
                break;

            default:
                driverManager = new DesktopChrome();
                break;

        }

        return driverManager;

    }


}
