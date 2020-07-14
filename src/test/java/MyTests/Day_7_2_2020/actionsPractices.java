package MyTests.Day_7_2_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class actionsPractices {

    @Test
    public void hover_over_test(){
        Driver.getDriver().get("https://www.amazon.com/");

        Actions actions = new Actions(Driver.getDriver());
//
        WebElement d = Driver.getDriver().findElement(By.id("icp-nav-flyout"));

        actions.moveToElement(d).perform();
    }

    @Test
    public void hoverTest(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        Actions actions = new Actions(Driver.getDriver());

        WebElement image1 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        actions.moveToElement(image1).perform();
        Assert.assertTrue(user1.isDisplayed());

        actions.moveToElement(image2).perform();
        Assert.assertTrue(user2.isDisplayed());

        actions.moveToElement(image3).perform();
        Assert.assertTrue(user3.isDisplayed());
    }
}
