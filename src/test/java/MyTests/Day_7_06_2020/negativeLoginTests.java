package MyTests.Day_7_06_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.Driver;
import utilities.configurationReader;

public class negativeLoginTests {

        WebDriver driver = Driver.getDriver();

        @Ignore
        @Test
    public void negatiflogintest(){

        driver.get(configurationReader.getProperty("url"));
        WebElement username = driver.findElement(By.id("prependedInput"));
        WebElement pass = driver.findElement(By.id("prependedInput2"));
        WebElement login = driver.findElement(By.id("_submit"));

        String user = configurationReader.getProperty("user_name");
        username.sendKeys(user);
        pass.sendKeys("t");
        login.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(errorMessage.isDisplayed(),"no");
    }

    @Test
    public void negativeLogin2(){
            driver.get(configurationReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();

        String username = configurationReader.getProperty("user_name");
        loginPage.usernameInput.sendKeys(username);

        loginPage.passwordInput.sendKeys("ljh");

        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }




}
