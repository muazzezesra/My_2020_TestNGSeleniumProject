package MyTests.Day_5_16_2020;

import Shortcuts.areSameElementsInList;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {


        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/","http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        ArrayList<String> titles = new ArrayList<>();

        for (String each:urls) {
            driver.get(each);
           titles.add(driver.getTitle());
        }
            driver.quit();

        if (areSameElementsInList.isSame(titles)){
            System.out.println("Passed");
        } else {
            System.out.println("Fail");
        }

        urls.forEach(p -> {if(p.startsWith("http://practice.cybertekschool.com")){ System.out.println("Pass"); } else { System.out.println("Fail"); }});


    }
}
