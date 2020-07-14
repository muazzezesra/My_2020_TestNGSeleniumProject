package MyTests.Day_6_01_2020;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/", "https://www.wayfair.com/", "https://www.walmart.com/", "https://www.westelm.com/");
        List<String> titles = new ArrayList<>();

        for (String each:urls) {
            driver.get(each);
            titles.add(driver.getTitle());
        }
     driver.quit();
        titles.replaceAll(p -> p.replaceAll(" ",""));
        titles.replaceAll(p->p.toLowerCase());

        for (int a =0 ; a < urls.size(); a++) {
            if (urls.get(a).contains(titles.get(a))){
                System.out.println("Pass");
            } else{
                System.out.println("Fail");
            }
         }


    }
}
