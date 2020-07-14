package MyTests.Day_6_18_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FileUploading {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Verify that file is uploaded")
    public void test1(){
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\meamj\\Desktop\\lol.txt");
        BrowserUtils.Wait(2);
        driver.findElement(By.id("file-submit")).submit();
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText() , "lol.txt", "File name is not same!");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
