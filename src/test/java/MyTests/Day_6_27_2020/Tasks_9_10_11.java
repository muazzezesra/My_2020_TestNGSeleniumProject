package MyTests.Day_6_27_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;
import utilities.SmartBearUtils;

import java.util.List;

public class Tasks_9_10_11 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.login(driver);
    }

    @Test
    public void task9(){
        WebElement check = driver.findElement(By.xpath("//html//tbody//tr[3]//td[1]//input[@type ='checkbox']"));
        check.click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class ='SampleTable']//tbody//tr//td[2]"));
        String name ="";
        for (WebElement each : listOfNames) {
            name += each.getText();
        }
        Assert.assertFalse(name.contains("Mark Smith"),"Mark Smith is not deleted");
    }

    @Test
    public void task10(){
        WebElement edit = driver.findElement(By.xpath("//table[@class ='SampleTable']//tbody//tr[4]//td[13]//input"));
        edit.click();
        WebElement name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        name.clear();
        name.sendKeys("Michael Jordan");
        driver.findElement(By.xpath("//input[@value ='Visa']")).click();
        driver.findElement(By.linkText("Update")).click();
        String myname = SmartBearUtils.ListOfNames(driver, "Michael Jordan");
        Assert.assertEquals(myname,"Michael Jordan");
    }

    @Test
    public void task11(){
        SmartBearUtils.removeName(driver, "Bob Feather");
        List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class ='SampleTable']//tbody//tr//td[2]"));
        String name ="";
        for (WebElement each : listOfNames) {
            name += each.getText();
        }
        Assert.assertFalse(name.contains("Bob Feather"),"Bob Feather is not deleted");
    }

    @AfterMethod
    public void teardown(){driver.quit();}
}
