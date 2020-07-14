package MyTests.Day_7_2_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class JavaScriptExecutorPractice {

    // scroll yapabilmek icin JavascriptExecutor class kullanilir.
    // #to scroll
    // #scroll task
    // #scroll
    // #JavascriptExecutor

    @Test
    public void jsexecutor_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/");

        WebElement cybertekschoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();

        BrowserUtils.Wait(3);

        //"arguments[0]" means first index of page starting at 0.
        //Where an " Element " is the locator on the web page.
        // Scrolled until element is visible.
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",cybertekschoolLink);

        /*
            We have just two steps to know.
            1- Create an object of JavascriptExecutor and cast it to the driver.
            2- use executeScript method, write down the javascript code and the element into the parameter.
         */
    }
}
