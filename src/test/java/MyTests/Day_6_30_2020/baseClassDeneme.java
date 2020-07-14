package MyTests.Day_6_30_2020;

import MyTests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.SmartBearUtils;

import java.util.List;

public class baseClassDeneme extends TestBase {


    @Test(description = "Smartbear software link verification")
    public void test1(){
        /*
            3. Enter username: “Tester”
            4. Enter password: “test”
            5. Click to Login button
            6. Print out count of all the links on landing page
            7. Print out each link text on this page
         */
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("ctl00_MainContent_password")).sendKeys("Test");
    }

    @Test
    public void test2(){
        SmartBearUtils.login(driver);
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class = 'SampleTable']/tbody/tr/td[2]"));

        String data = "";
        for (WebElement each: elements){
            String name = each.getText();
            data+= name;
        }
        Assert.assertTrue(data.contains("Mark Smith"),"Doesn't contain this name");
    }


}
