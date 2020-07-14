package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SmartBearUtils {

    public static void login(WebDriver driver){
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    public static String ListOfNames(WebDriver driver, String name){
        List<WebElement> names = driver.findElements(By.xpath("//table[@class ='SampleTable']//tbody//tr//td[2]"));
        String choosenName = "";
        for (WebElement each : names){
            if (each.getText().equals(name)){
                choosenName = each.getText();
                break;
            }
        }
        return choosenName;
    }
// [id ^= 'ctl00_MainContent_orderGrid_']
    public static void removeName(WebDriver driver, String name){
        List<WebElement> names = driver.findElements(By.xpath("//table[@class ='SampleTable']//tbody//tr//td[2]"));
        List<WebElement> boxes = driver.findElements(By.xpath("//table[@class ='SampleTable']//tbody//tr//td[1]//*"));
        for(int i =0; i <names.size();i++){
           String str = names.get(i).getText();
           if (str.equals(name)){
               boxes.get(i).click();
               break;
           }
        }
        BrowserUtils.Wait(2);
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
    }

}
