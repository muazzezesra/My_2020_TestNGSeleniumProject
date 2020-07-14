package MyTests.Day_6_01_2020;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/", "https://www.wayfair.com/", "https://www.walmart.com/", "https://www.westelm.com/");

        for (int i=0; i<urls.size(); i++){
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(urls.get(i));
            String title = driver.getTitle().toLowerCase().replaceAll(" ","");
            if(driver.getCurrentUrl().contains(title)){
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
            driver.close();
        }


    }
}
