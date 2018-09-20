package test.java.smokeTests;

import main.java.pages.CoveragePage;
import main.java.pages.SuppliesPage;
import main.java.pages.HomePage;
import main.java.pages.SignUpPage;

import main.java.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CoveragePageTest extends BaseTest {

    @Test
    public void coveragePageVerificationTest() {

        //test data set up
        TestUtils.DATA_FILE = "livongoTestData1.properties";

        //opens home page
        HomePage homePage = new HomePage();

        //clicks on get started btn and lands on Signup page
        SignUpPage signUpPage = homePage.clickOnGetStarted();

        //enters all the fields and lands on supplies Page
        SuppliesPage suppliesPage = signUpPage
                .enterFirstName()
                .enterLastName()
                .enterDob()
                .enterEmail()
                .enterPassword()
                .clickTermsCheckbox().clickSubmitBtn();

        //enter all the field on supplies page and lands on coverage page
        CoveragePage coveragePage = suppliesPage.enterstreetName()
                .enterCity()
                .selectState()
                .enterZipcode()
                .enterPhone()
                .clickNextBtn();

        //verifies page title on coverage page
        Assert.assertTrue(coveragePage.returnPageTitleVerification());


    }


}
