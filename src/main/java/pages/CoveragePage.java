package main.java.pages;

import main.java.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CoveragePage extends BasePage {

    /**
     * Class Constructor.
     */
    public CoveragePage(WebDriver driver) {
        super(driver);
        waitForPageLoad();
        utils.log("landed on coverage page");
    }

    private final String PAGE_TITLE_TEXT = ".//*[contains(text(),'Who has you covered?')]";


    @FindBy(xpath = PAGE_TITLE_TEXT)
    WebElement pageTitle;

    /**
     * returns text.
     */
    public String returnPageTitle() {
        String txt = "";
        try {

            pageTitle.getText();

        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return txt;
    }

}
