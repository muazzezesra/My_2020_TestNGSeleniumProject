package MyTests.Day_6_05_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;
import utilities.StringUtility;

public class VerifyUrlHasChanged {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        BrowserUtils.Wait(2);
        String expectedUrl = driver.getCurrentUrl();
        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys("random_email@email.com");
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
        String currentUrl = driver.getCurrentUrl();

        StringUtility.verifyEqual("http://practice.cybertekschool.com/email_sent",currentUrl);

        driver.close();
    }


}
