package MyTests.Day_6_12_2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import java.util.Arrays;
import java.util.List;

public class dene {
    public static void main(String[] args) {

        for (int i =0; i <7; i++) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://www.apple.com");
            List<WebElement> HeaderLinks = Arrays.asList(driver.findElement(By.xpath("(//a[starts-with(@class , 'ac-gn-link ac-gn-link')])[4]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class , 'ac-gn-link ac-gn-link')])[5]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class , 'ac-gn-link ac-gn-link')])[6]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class , 'ac-gn-link ac-gn-link')])[7]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class , 'ac-gn-link ac-gn-link')])[8]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class , 'ac-gn-link ac-gn-link')])[9]")),
                    driver.findElement(By.xpath("(//a[starts-with(@class , 'ac-gn-link ac-gn-link')])[10]")));

            HeaderLinks.get(i).click();

            List<WebElement> listOfLinksOnThePage = driver.findElements(By.xpath("//a"));

            int totalMissingText = 0;
            int totalHasText = 0;
            int totalLinks = 0;


            totalLinks += listOfLinksOnThePage.size();
            for (WebElement links : listOfLinksOnThePage) {
                String link = links.getText();
                if (link.isEmpty()) {
                    totalMissingText++;
                } else {
                    totalHasText++;
                }
            }

            driver.close();
            System.out.println("Total missing text: " + totalMissingText);
            System.out.println("Total text number: " + totalHasText);
            System.out.println("Total link number: " + totalLinks);
        }
    }
}
