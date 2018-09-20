package main.java.pages;

import main.java.BasePage;
import main.java.utils.AssertUtils;
import main.java.utils.BrowserUtils;
import main.java.utils.JavaScriptUtils;
import main.java.utils.WebElementUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CoveragePage extends BasePage {

    /**
     * Class Constructor.
     */
    public CoveragePage() {
        super();
        PageFactory.initElements(driver, this);
        JavaScriptUtils.waitForPageLoad();
        BrowserUtils.waitForClickable(code_id, 20);
        log("landed on coverage page");
    }

    private final String PAGE_TITLE_TEXT = ".//*[@id='step-container']//div[@ng-if='stepTitle']";
    private final String CODE_ID = "coverage-input-promocode";

    @FindBy(xpath = PAGE_TITLE_TEXT)
    WebElement pageTitle;

    @FindBy(id = CODE_ID)
    WebElement code_id;

    /**
     * returns text.
     */
    public boolean returnPageTitleVerification() {
        String found = "";
        try {
            BrowserUtils.getElementWithFluentWait(PAGE_TITLE_TEXT, 10, 10);
            found = WebElementUtils.getText(pageTitle);

        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":returnPageTitle");
        }
        String expected = testdataInput.get("page_title");
        if (found.equals(expected)) {
            return true;
        } else {
            AssertUtils.printExpectedAndFound(found,
                    expected, "Coverage page returnPageTitleVerification");
        }

        return false;

    }

}
