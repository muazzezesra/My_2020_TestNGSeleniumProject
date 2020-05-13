package MyTests.Day_5_13_2020;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

public class DenemeTest {
    public static void main(String[] args) {
       WebDriver driver = BrowserFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.get("http://google.com");
       driver.navigate().to("http://amazon.com");

       String actualResult = driver.getTitle();
       String expectedResult = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

       if (actualResult.equals(expectedResult)){
           System.out.println("Test passed");
       } else{
           System.out.println("Test failed");
       }
       driver.quit();
    }
}
