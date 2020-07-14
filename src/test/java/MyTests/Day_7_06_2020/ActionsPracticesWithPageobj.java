package MyTests.Day_7_06_2020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class ActionsPracticesWithPageobj {
WebDriver driver = Driver.getDriver();
HoversPage hoversPage = new HoversPage();
Actions actions = new Actions(driver);
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/hovers");

        actions.moveToElement(hoversPage.image1).perform();
        Assert.assertTrue(hoversPage.user1.isDisplayed());

        actions.moveToElement(hoversPage.image2).perform();
        Assert.assertTrue(hoversPage.user2.isDisplayed());

        actions.moveToElement(hoversPage.image3).perform();
        Assert.assertTrue(hoversPage.user3.isDisplayed());

    }




}
