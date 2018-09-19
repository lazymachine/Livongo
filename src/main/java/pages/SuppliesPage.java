package main.java.pages;

import main.java.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sun.tools.asm.Cover;

import java.util.List;

public class SuppliesPage extends BasePage {

    /**
     * Class Constructor.
     */
    public SuppliesPage(WebDriver driver) {
        super(driver);
        waitForPageLoad();
        Assert.assertTrue(verifyPage("SuppliesPage", pageverificationtxt));
        utils.log("landed on supplies page");
    }

    private final String PAGE_VERIFICATION_TEXT = ".//*[contains(text(),'Shipping & Supplies')]";
    private final String STREET_ADDRESS_ID = "shipping-street-address";
    private final String CITY_ID = "shipping-city";
    private final String STATE_ID = "shipping-select-state";
    private final String ZIPCODE_ID = "shipping-zip-code";
    private final String PHONE_ID = "shipping-input-phone";
    private final String NEXT_XPATH = ".//*[@class='step-button']/button";

    @FindBy(xpath = PAGE_VERIFICATION_TEXT)
    protected WebElement pageverificationtxt;

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
     *
     * @param street to be entered
     */
    public SuppliesPage enterstreetName(String street) {
        try {
            streetAddressEle.clear();
            streetAddressEle.sendKeys(street);
            utils.log("street entered: " + street);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }

    /**
     * enters city name.
     *
     * @param city name to be entered
     */
    public SuppliesPage enterCity(String city) {

        try {
            cityEle.clear();
            cityEle.sendKeys(city);
            utils.log("city entered: " + city);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }


    /**
     * enters state name.
     *
     * @param state name to be entered
     */
    public SuppliesPage selectState(String state) {

        try {

            Select stateItem = new Select(stateEle);

            stateItem.selectByVisibleText(state);

            utils.log("state selected: " + state);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }

    /**
     * enters zip code.
     *
     * @param zipcode to be entered
     */
    public SuppliesPage enterZipcode(String zipcode) {

        try {
            zipcodeEle.clear();
            zipcodeEle.sendKeys(zipcode);
            utils.log("zipcode entered: " + zipcode);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return this;
    }


    /**
     * enters phone.
     *
     * @param phone name to be entered
     */
    public SuppliesPage enterPhone(String phone) {

        try {
            phoneEle.clear();
            phoneEle.sendKeys(phone);
            utils.log("phone entered: " + phone);
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
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
            waitForPageLoad();
            next_btn.click();
            utils.log("next btn clicked from supplies page");
        } catch (NoSuchElementException e) {
            utils.logError(e.toString());
        }
        return new CoveragePage(driver);
    }

}
