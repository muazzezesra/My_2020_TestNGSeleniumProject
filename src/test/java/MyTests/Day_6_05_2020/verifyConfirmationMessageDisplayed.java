package MyTests.Day_6_05_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;
import utilities.StringUtility;

public class verifyConfirmationMessageDisplayed {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        BrowserUtils.Wait(2);
        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys("random_email@email.com");
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
        WebElement message = driver.findElement(By.id("content"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = message.getText();
        StringUtility.verifyEqual(expectedMessage,actualMessage);
        driver.close();

    }
}
