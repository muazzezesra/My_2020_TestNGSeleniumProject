package MyTests.Day_6_18_2020;

import Shortcuts.SwitchWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.Set;

public class WindowSwitch {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test1(){
       String oldWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.Wait(5);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windows:windowHandles) {
            if (!windows.equals(oldWindow)){
                driver.switchTo().window(windows);
            }
        }
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "This tab is not Fresh tab");



        String pageTitle = "Practice";
        SwitchWindow.switchWindow(pageTitle, windowHandles, driver); // my own method


    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
