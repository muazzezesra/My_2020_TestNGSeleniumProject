package MyTests.Day_6_11_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class TestWithDifferentLocators {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        List<WebElement> d = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: "+d.size());

        for (WebElement element : d){
            System.out.println(element.getText());
        }
driver.quit();

    }
}
