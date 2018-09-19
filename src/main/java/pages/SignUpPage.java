package main.java.pages;

import main.java.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage extends BasePage {

    /**
     * Class Constructor.
     */
    public SignUpPage(WebDriver driver) {
        super(driver);
        waitForPageLoad();
        Assert.assertTrue(verifyPage("SignUpPage", pageverificationtxt));
        utils.log("landed on signup page");
    }

    private final String PAGE_VERIFICATION_TEXT = ".//*[contains(text(),'Create your account.')]";
    private final String FIRST_NAME_ID = "get-started-input-firstname";
    private final String LAST_NAME_ID = "get-started-input-lastname";
    private final String DOB_MONTH_ID = "get-started-input-month";
    private final String DOB_DAY_ID = "get-started-input-day";
    private final String DOB_YEAR_ID = "get-started-input-year";
    private final String EMAIL_ID = "get-started-input-email";
    private final String PASSWORD_ID = "get-started-input-password";
    private final String TERMS_ID = "get-started-terms-and-conditions";
    private final String SUBMIT_XPATH = ".//*[@class='step-button']/button";

    @FindBy(xpath = PAGE_VERIFICATION_TEXT)
    protected WebElement pageverificationtxt;

    @FindBy(id = FIRST_NAME_ID)
    protected WebElement firstNameInput;

    @FindBy(id = LAST_NAME_ID)
    protected WebElement lastNameInput;

    @FindBy(id = DOB_MONTH_ID)
    protected WebElement dob_month_input;

    @FindBy(id = DOB_DAY_ID)
    protected WebElement dob_day_input;

    @FindBy(id = DOB_YEAR_ID)
    protected WebElement dob_year_input;

    @FindBy(id = EMAIL_ID)
    protected WebElement useremail_input;

    @FindBy(id = PASSWORD_ID)
    protected WebElement passoword_input;

    @FindBy(id = TERMS_ID)
    protected WebElement terms_checkbox;

    @FindBy(xpath = SUBMIT_XPATH)
    protected WebElement submit_btn;

    /**
     * enters first name.
     *
     * @param firstName name to be entered
     */
    public SignUpPage enterFirstName(String firstName) {
        try {
            firstNameInput.clear();
            firstNameInput.sendKeys(firstName);
            utils.log("first name entered: " + firstName);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }

    /**
     * enters last name.
     *
     * @param lastName name to be entered
     */
    public SignUpPage enterLastName(String lastName) {

        try {
            lastNameInput.clear();
            lastNameInput.sendKeys(lastName);
            utils.log("last entered: " + lastName);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }


    /**
     * enters last name.
     *
     * @param dob name to be entered
     */
    public SignUpPage enterDob(String dob) {
        String dobArr[] = dob.split("-");

        try {
            dob_month_input.clear();
            dob_month_input.sendKeys(dobArr[0]);

            dob_day_input.clear();
            dob_day_input.sendKeys(dobArr[0]);

            dob_year_input.clear();
            dob_year_input.sendKeys(dobArr[0]);

            utils.log("dobentered: " + dob);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }


    /**
     * enters email.
     */
    public SignUpPage enterEmail() {

        String email = utils.createUniqueEmail();

        try {
            useremail_input.clear();
            useremail_input.sendKeys(email);
            utils.log("email entered: " + email);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }


    /**
     * enters email.
     *
     * @param password name to be entered
     */
    public SignUpPage enterPassword(String password) {

        try {
            passoword_input.clear();
            passoword_input.sendKeys(password);
            utils.log("password entered: " + password);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }


    /**
     * click terms and condition checkbox.
     */
    public SignUpPage clickTermsCheckbox() {

        try {
            terms_checkbox.click();
            utils.log("terms and condition checkbox clicked");
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }


    /**
     * clicks submit btn
     *
     * @return SuppliesPage object
     */
    public SuppliesPage clickSubmitBtn() {
        try {
            waitForPageLoad();
            submit_btn.click();
            utils.log("submit btn clicked from signup page");
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return new SuppliesPage(driver);
    }


}
