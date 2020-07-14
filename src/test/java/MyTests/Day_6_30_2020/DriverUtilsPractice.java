package MyTests.Day_6_30_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.configurationReader;

public class DriverUtilsPractice {

    @Test
    public void driver_practice(){
        Driver.getDriver().get("http://google.com");
        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));
        googleSearch.sendKeys(configurationReader.getProperty("testdata")+ Keys.ENTER);
    }
}
