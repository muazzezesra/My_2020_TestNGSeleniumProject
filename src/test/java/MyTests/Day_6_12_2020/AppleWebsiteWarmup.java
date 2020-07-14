package MyTests.Day_6_12_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppleWebsiteWarmup {
    public static void main(String[] args) {
        /*
        1. Open Chrome browser
        2. Go to https://www.apple.com
        3. Click to all of the headers one by one
        a. Mac, iPad, iPhone, Watch, TV, Music, Support
        4. Print out how many links on each page with the titles of the pages
        5. Loop through all
        6. Print out how many link is missing text TOTAL
        7. Print out how many link has text TOTAL
        8. Print out how many total link TOTAL
         */
// //div//ul[2]//li//a//span
// (//a[starts-with(@class , 'ac-gn-link ac-gn-link')])[4]

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.apple.com");

        int totalMissingText = 0;
        int totalHasText = 0;
        int totalLinks = 0;
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


            driver.findElement(By.xpath("(//a[starts-with(@class , 'ac-gn-link ac-gn-link')])[4]")).click();

            List<WebElement> elements = driver.findElements(By.xpath("//a"));

            System.out.println("Total number of links: " + elements.size());

            totalLinks += elements.size();

            for (WebElement links : elements) {
                String link = links.getText();
                System.out.println(link);

                if (link.isEmpty()) {
                    totalMissingText++;
                } else {
                    totalHasText++;
                }
            }
            driver.close();

        System.out.println("Total missing text: "+totalMissingText);
        System.out.println("Total text number: "+totalHasText);
        System.out.println("Total link number: "+totalLinks);

    }
}
