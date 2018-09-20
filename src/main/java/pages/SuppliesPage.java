package main.java.pages;

import main.java.BasePage;

import main.java.utils.BrowserUtils;
import main.java.utils.WebElementUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SuppliesPage extends BasePage {

    /**
     * Class Constructor.
     */
    public SuppliesPage() {
        super();
        PageFactory.initElements(driver, this);
        log("landed on supplies page");
    }

    private final String STREET_ADDRESS_ID = "shipping-street-address";
    private final String CITY_ID = "shipping-city";
    private final String STATE_ID = "shipping-select-state";
    private final String ZIPCODE_ID = "shipping-zip-code";
    private final String PHONE_ID = "shipping-input-phone";
    private final String NEXT_XPATH = ".//button[contains(text(),'Next: Coverage')]";


    @FindBy(id = STREET_ADDRESS_ID)
    protected WebElement streetAddressEle;

    @FindBy(id = CITY_ID)
    protected WebElement cityEle;

    @FindBy(id = STATE_ID)
    protected WebElement stateEle;

    @FindBy(id = ZIPCODE_ID)
    protected WebElement zipcodeEle;

    @FindBy(id = PHONE_ID)
    protected WebElement phoneEle;

    @FindBy(xpath = NEXT_XPATH)
    protected WebElement next_btn;

    /**
     * enters street address.
     */
    public SuppliesPage enterstreetName() {
        try {
            String street = testdataInput.get("street");
            WebElementUtils.fill(streetAddressEle, street);
            log("street entered: " + street);
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":enterstreetName");
        }
        return this;
    }

    /**
     * enters city name.
     */
    public SuppliesPage enterCity() {

        try {
            String city = testdataInput.get("city");
            WebElementUtils.fill(cityEle, city);
            log("city entered: " + city);
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":enterCity");
        }
        return this;
    }


    /**
     * enters state name.
     */
    public SuppliesPage selectState() {

        try {
            String state = testdataInput.get("state");

            WebElementUtils.selectDropDownState(stateEle, state);

            log("state selected: " + state);
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":selectState");
        }
        return this;
    }

    /**
     * enters zip code.
     */
    public SuppliesPage enterZipcode() {

        try {
            String zipcode = testdataInput.get("zipcode");
            WebElementUtils.fill(zipcodeEle, zipcode);

            log("zipcode entered: " + zipcode);
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":enterZipcode");
        }
        return this;
    }


    /**
     * enters phone.
     */
    public SuppliesPage enterPhone() {

        try {
            String phone = testdataInput.get("phone");
            try {
                BrowserUtils.waitFor(phoneEle, 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            phoneEle.sendKeys(phone);
            log("phone entered: " + phone);
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":enterPhone");
        }
        return this;
    }


    /**
     * clicks submit btn
     *
     * @return CoveragePage object
     */
    public CoveragePage clickNextBtn() {
        try {

            WebElementUtils.click(next_btn);
            log("next btn clicked from supplies page");
        } catch (NoSuchElementException e) {
            logError(e, "Error at method - "
                    + this.getClass().getSimpleName() + ":clickNextBtn");
        }
        return new CoveragePage();
    }

}
