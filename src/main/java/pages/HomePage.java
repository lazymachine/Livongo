package main.java.pages;

import main.java.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.utils.PropertyFileUtils;

public class HomePage extends BasePage {

    /**
     * Class Constructor.
     */
    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    private final String URL = PropertyFileUtils.getConfig().getProperty("testurl");
    private final String JOIN_NOW_ID = "(.//*[@id='landing-button-signup'])[1]";


    @FindBy(xpath = JOIN_NOW_ID)
    WebElement joinNowBtn;


    /**
     * opens the home page url.
     */
    public void open() {
        driver.navigate().to(URL);
        utils.log("navigate to url: " + URL);
        waitForPageLoad();

    }

    /**
     * Clicks on Hotel Citywide Tab.
     *
     * @return HotelCityWide Page Object
     */
    public SignUpPage clickOnGetStarted() {
        try {
            joinNowBtn.click();
            utils.log("get started button clicked");
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return new SignUpPage(driver);
    }


}
