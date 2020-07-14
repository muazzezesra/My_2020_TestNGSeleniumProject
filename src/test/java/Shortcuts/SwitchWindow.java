package Shortcuts;

import org.openqa.selenium.WebDriver;
import utilities.BrowserUtils;

import java.util.Set;

public class SwitchWindow {

    public static void switchWindow(String pageTitle, Set<String> windowsHandles, WebDriver driver){

        for(String window: windowsHandles ){
            driver.switchTo().window(window);
            BrowserUtils.Wait(1);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
        System.out.println(driver.getTitle());
    }
}
