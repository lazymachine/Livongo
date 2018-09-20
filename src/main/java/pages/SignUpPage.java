package main.java.pages;

import main.java.BasePage;
import main.java.utils.BrowserUtils;
import main.java.utils.WebElementUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignUpPage extends BasePage {

    /**
     * Class Constructor.
     */
    public SignUpPage() {
        super();
        PageFactory.initElements(driver, this);
        log("landed on signup page");
    }

    private final String FIRST_NAME_ID = "get-started-input-firstname";
    private final String LAST_NAME_ID = "get-started-input-lastname";
    private final String DOB_MONTH_ID = "get-started-input-month";
    private final String DOB_DAY_ID = "get-started-input-day";
    private final String DOB_YEAR_ID = "get-started-input-year";
    private final String EMAIL_ID = "get-started-input-email";
    private final String PASSWORD_ID = "get-started-input-password";
    private final String TERMS_XPATH = ".//*[@class='lv-checkbox']";
    private final String SUBMIT_XPATH = ".//*[@class='step-button']/button";


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

    @FindBy(xpath = TERMS_XPATH)
    protected WebElement terms_checkbox;

    @FindBy(xpath = SUBMIT_XPATH)
    protected WebElement submit_btn;

    /**
     * enters first name.
     */
    public SignUpPage enterFirstName() {
        try {
            String firstName = testdataInput.get("firstname");
            WebElementUtils.fill(firstNameInput, firstName);
            log("first name entered: " + firstName);
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":enterFirstName");
        }
        return this;
    }

    /**
     * enters last name.
     */
    public SignUpPage enterLastName() {

        try {
            String lastName = testdataInput.get("lastname");

            WebElementUtils.fill(lastNameInput, lastName);

            log("last entered: " + lastName);
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":enterLastName");
        }
        return this;
    }


    /**
     * enters last name.
     */
    public SignUpPage enterDob() {

        try {
            String dob = testdataInput.get("dob");

            String dobArr[] = dob.split("-");

            WebElementUtils.fill(dob_month_input, dobArr[0]);

            WebElementUtils.fill(dob_day_input, dobArr[1]);

            WebElementUtils.fill(dob_year_input, dobArr[2]);


            log("dobentered: " + dob);

        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":enterDob");
        }
        return this;
    }


    /**
     * enters email.
     */
    public SignUpPage enterEmail() {
        try {
            String email = utils.createUniqueEmail();
            WebElementUtils.fill(useremail_input, email);
            log("email entered: " + email);
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":enterDob");
        }
        return this;
    }


    /**
     * enters password.
     */
    public SignUpPage enterPassword() {

        try {
            String password = testdataInput.get("password");
            WebElementUtils.fill(passoword_input, password);
            log("password entered: " + password);
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":enterPassword");

        }
        return this;
    }


    /**
     * click terms and condition checkbox.
     */
    public SignUpPage clickTermsCheckbox() {

        try {
            WebElementUtils.click(terms_checkbox);
            log("terms and condition checkbox clicked");
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":clickTermsCheckbox");
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
            WebElementUtils.click(submit_btn);
            log("submit btn clicked from signup page");
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":clickSubmitBtn");
        }
        return new SuppliesPage();
    }


}
