package MyTests.Day_7_2_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Uploading {

    @Test
    public void uploadingfile(){
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        Driver.getDriver().findElement(By.linkText("File Upload")).click();
        WebElement choose = Driver.getDriver().findElement(By.id("file-upload"));
        choose.sendKeys("C:\\Users\\meamj\\Desktop\\lol.txt");
        WebElement fileupload = Driver.getDriver().findElement(By.id("file-submit"));

        fileupload.click();

        WebElement uploadMessage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));

        Assert.assertTrue(uploadMessage.isDisplayed());
    }
}
