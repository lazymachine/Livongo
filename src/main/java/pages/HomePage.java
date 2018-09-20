package main.java.pages;

import main.java.BasePage;

import main.java.utils.JavaScriptUtils;
import main.java.utils.WebElementUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import main.java.utils.PropertyFileUtils;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    /**
     * Class Constructor.
     */
    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
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
        log("navigate to url: " + URL);
        JavaScriptUtils.waitForPageLoad();

    }

    /**
     * Clicks on clickOnGetStarted.
     *
     * @return SignUpPage Object
     */
    public SignUpPage clickOnGetStarted() {
        try {
            WebElementUtils.click(joinNowBtn);
            log("get started button clicked");
        } catch (NoSuchElementException e) {
            logError(e, "failed on method "
                    + this.getClass().getSimpleName()
                    + ":" + getMethodName() + "\n");
        }
        return new SignUpPage();
    }


}
