package MyTests.Day_6_18_2020;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class popupHandling {

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Click OK in pop up message")
    public void test1() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        BrowserUtils.Wait(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
       // driver.switchTo().alert().accept(); or this. shorter
        BrowserUtils.Wait(2);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
