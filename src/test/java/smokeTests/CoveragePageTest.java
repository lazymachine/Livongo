package test.java.smokeTests;

import main.java.pages.CoveragePage;
import main.java.pages.SuppliesPage;
import main.java.pages.HomePage;
import main.java.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.utils.PropertyFileUtils;

import java.util.Properties;

public class CoveragePageTest extends BaseTest {

    @Test
    public void coveragePageVerificationTest() {
        try {
            //test data set up
            Properties prop = PropertyFileUtils.getTestData("livongoTestData1.properties");

            //opens home page
            HomePage homePage = new HomePage(driver);

            //clicks on get started btn and lands on Signup page
            SignUpPage signUpPage = homePage.clickOnGetStarted();

            //enters all the fields and lands on supplies Page
            SuppliesPage suppliesPage = signUpPage
                    .enterFirstName(prop.getProperty("firstname"))
                    .enterLastName(prop.getProperty("lastname"))
                    .enterDob(prop.getProperty("dob"))
                    .enterEmail()
                    .enterPassword(prop.getProperty("password"))
                    .clickTermsCheckbox().clickSubmitBtn();

            //enter all the field on supplies page and lands on coverage page
            CoveragePage coveragePage = suppliesPage.enterstreetName(prop.getProperty("street"))
                    .enterCity(prop.getProperty("city"))
                    .selectState(prop.getProperty("state"))
                    .enterZipcode(prop.getProperty("zipcode"))
                    .enterPhone(prop.getProperty("phone"))
                    .clickNextBtn();

            //return page title for coverage page
            String coveragePageTitleTxt = coveragePage.returnPageTitle();

            //verifies page title on coverage page
            Assert.assertTrue(coveragePageTitleTxt.equals(prop.getProperty("page_title")));

        } catch (Exception ex) {
            utils.logError(ex.toString());
            Assert.fail("Exception found on coveragePageVerificationTest");
        }
    }


}
