package MyTests.Day_6_05_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;
import utilities.StringUtility;

public class webelementDeneme {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        BrowserUtils.Wait(2);
        String expectedTitle = driver.getTitle();
        WebElement element = driver.findElement(By.id("form_submit"));
        element.click();
        String currentTitle = driver.getTitle();
        driver.close();
        StringUtility.verifyEqual(expectedTitle, currentTitle);
    }
}
