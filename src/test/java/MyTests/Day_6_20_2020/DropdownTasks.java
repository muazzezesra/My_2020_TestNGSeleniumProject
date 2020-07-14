package MyTests.Day_6_20_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;
import java.util.List;

public class DropdownTasks {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test(description = "Verifying “Simple dropdown” and “State selection” dropdown default values")
    public void test1(){
        /*
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Verify “Simple dropdown” default selected value is correct
        Expected: “Please select an option”
        4. Verify “State selection” default selected value is correct
        Expected: “Select a State”
         */
        WebElement dropdown = driver.findElement(By.id("state"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Select a State");
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Select a State","Selected value is not correct!");
    }

    @Test(description = "Selecting state from State dropdown and verifying result")
    public void test2(){
        /*
        3. Select Illinois
        4. Select Virginia
        5. Select California
        6. Verify final selected option is California.
           Use all Select options. (visible text, value, index)
         */
        WebElement dropdown = driver.findElement(By.id("state"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Illinois");
        select.selectByVisibleText("Virginia");
        select.selectByVisibleText("California");
        String california = select.getFirstSelectedOption().getText();
        Assert.assertEquals(california, "California", "Wrong state selected!");

    }

    @Test(description = "Selecting date on dropdown and verifying")
    public void test3(){
        /*
        3. Select “December 1st, 1921” and verify it is selected.
        Select year using : visible text
        Select month using : value attribute
        Select day using : index number
         */
        WebElement year = driver.findElement(By.id("year"));
        Select select = new Select(year);
        select.selectByVisibleText("1921");
        String year1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(year1, "1921","False!");
        BrowserUtils.Wait(2);

        WebElement month = driver.findElement(By.id("month"));
        Select select2 = new Select(month);
        select2.selectByValue("11");
        String month1 = select2.getFirstSelectedOption().getText();
        Assert.assertEquals(month1, "December","False!");
        BrowserUtils.Wait(2);

        WebElement day = driver.findElement(By.id("day"));
        Select select3 = new Select(day);
        select3.selectByIndex(0);
        String day1 = select3.getFirstSelectedOption().getText();
        Assert.assertEquals(day1, "1","False!");
    }

    @Test(description = "Selecting value from multiple select dropdown")
    public void test4(){
        /*
            3. Select all the options from multiple select dropdown.
            4. Print out all selected values.
            5. Deselect all values
         */
        WebElement multiple = driver.findElement(By.cssSelector("[name = 'Languages']")); // our dropdown's element
        Select select = new Select(multiple);

        // Since I want to use selectByVisibleText() method, I need to get all of the elements from dropdown's list
        // to select all of them, I need to go, one by one.
        List<WebElement> languages = driver.findElements(By.cssSelector("[name = 'Languages'] option")); // gives 6 options
        for (WebElement each : languages){
            BrowserUtils.Wait(2);
            select.selectByVisibleText(each.getText());
        }

        // to print selected values
       List<WebElement> selected = select.getAllSelectedOptions();
        for (int i = 0; i < selected.size(); i++) {
            System.out.println(selected.get(i).getText());
        }
        select.deselectAll();
    }

    @Test(description = "Selecting value from non-select dropdown")
    public void test5(){
        /*
            3. Click to non-select dropdown
            4. Select Facebook from dropdown
            5. Verify title is “Facebook - Log In or Sign Up”
         */
        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.Wait(2);
        driver.findElement(By.linkText("Facebook")).click();
        Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up", "Title is wrong!");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
