package MyTests.Day_7_07_2020;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ForgotPasswordPage;
import utilities.Driver;
import utilities.configurationReader;

public class ForgotPasswordTests {

WebDriver driver = Driver.getDriver();
LoginPage loginPage = new LoginPage();
ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test
    public void tc35_title_url_verification(){
        /*
        1. Go to https://qa2.vytrack.com
        2. Click to “Forgot your password?” link
        3. Verify title changed to expected
        Expected: “Forgot Password”
        4. Verify url is as expected:
        Expected: “https://qa2.vytrack.com/user/reset-request”
        Note: Follow Page Object Model design pattern
        */

         driver.get(configurationReader.getProperty("url"));
         loginPage.forgotPasswordLink.click();
         String expectedTitle = "Forgot Password";
         String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle,"Title is wrong!");

        String ExpectedURL = "https://qa2.vytrack.com/user/reset-request";
        String ActualURL = driver.getCurrentUrl();

        Assert.assertEquals(ActualURL, ExpectedURL,"Wrong URL!");
    }

    @Test
    public void tc36_errorMessage(){
        /*
            1. Go to https://qa2.vytrack.com/user/reset-request
            2. Enter random username
            3. Click to request button
            4. Verify error message is displayed
            5. Verify error message text is as expected.
            Expected: There is no active user with username or email address “given text”.
            Note: Follow Page Object Model design pattern
         */
        driver.get(configurationReader.getProperty("forgotPassword_URL"));
        String randomString = "dsfsg";
        forgotPasswordPage.inputBox.sendKeys(randomString);
        forgotPasswordPage.requestButton.click();
        Assert.assertTrue(forgotPasswordPage.errorMessage.isDisplayed());

        String expectedMessage = "There is no active user with username or email address \""+randomString+"\".";
        String actualMessage = forgotPasswordPage.errorMessage.getText();

        Assert.assertEquals(actualMessage,expectedMessage,"Message Is Not The Same!");
    }


}
