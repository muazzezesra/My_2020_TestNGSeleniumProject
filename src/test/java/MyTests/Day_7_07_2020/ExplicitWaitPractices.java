package MyTests.Day_7_07_2020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitWaitPractices {

    WebDriver driver = Driver.getDriver();

    @Test
    public void tc40_dynamic_title_test(){
         /*
        1. Go to http://practice.cybertekschool.com/dynamic_loading/7
        2. Wait until title is “Dynamic Title”
        3. Assert : Message “Done” is displayed.
        4. Assert : Image is displayed.
        Note: Follow POM
     */

        driver.get("http://practice.cybertekschool.com/dynamic_loading/7");

        Loading7Page loading7Page = new Loading7Page();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(loading7Page.DoneMessage));

        Assert.assertTrue(loading7Page.DoneMessage.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(loading7Page.spongeBobImage));

        Assert.assertTrue(loading7Page.spongeBobImage.isDisplayed());
    }

    @Test
    public void tc41(){
        /*
            1. Go to http://practice.cybertekschool.com/dynamic_loading/1
            2. Click to start
            3. Wait until loading bar disappears
            4. Assert username inputbox is displayed
            5. Enter username: tomsmith
            6. Enter password: incorrectpassword
            7. Click to Submit button
            8. Assert “Your username is invalid!” text is displayed
         */

        Loading1Page loading1Page  =new Loading1Page();

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        loading1Page.startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(loading1Page.username));

        Assert.assertTrue(loading1Page.username.isDisplayed());

        loading1Page.username.sendKeys("tomsmith");
        loading1Page.password.sendKeys("incorrectpassword");

        loading1Page.SubmitButton.click();

        Assert.assertTrue(loading1Page.errorMessage.isDisplayed());

    }


}
