package MyTests.Day_7_06_2020;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class ActionsPractice {
    WebDriver driver = Driver.getDriver();
    Actions actions;
    @Test
    public void scrollingWithActions(){
        driver.get("http://practice.cybertekschool.com/");

       actions = new Actions(driver);

        WebElement cybertekLink = driver.findElement(By.linkText("Cybertek School"));

        actions.moveToElement(cybertekLink).perform(); // so we scrolled until the element is visible
    }

    @Test
    public void tc16_doubleClickTest(){

        // 1. Go to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        // 2. Switch	to	iframe.
        // 1. index 2. id name value 3. locate it as a webelement and pass it into
        // 3. Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
        // 4. Assert:	Text’s	“style”	attribute	value	contains	“red”.

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.switchTo().frame("iframeResult");
        WebElement textDoubleClick = driver.findElement(By.id("demo"));
        actions = new Actions(driver);
        actions.doubleClick(textDoubleClick).perform();
        String actual = textDoubleClick.getAttribute("style");
        String expected = "color: red;";
        Assert.assertTrue(actual.equals(expected));

    }

    @Test
    public void task17_DragAndDrop(){
        /*
            1. Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
            2. Drag	and	drop	the	small	circle	to	bigger	circle.
            3. Assert:
            -Text	in	big	circle	changed to:	“You	did	great!”
         */

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement smallCircle = driver.findElement(By.id("draggable"));
        WebElement bigCircle = driver.findElement(By.id("droptarget"));

        actions = new Actions(driver);

       actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();
       String beforeReleasing = bigCircle.getText();
       String expectedtext = "Now drop...";
       Assert.assertEquals(beforeReleasing,expectedtext);

        actions.dragAndDrop(smallCircle, bigCircle).perform();  // we can do this way too

        String actual = bigCircle.getText();
        String expected = "You did great!";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void task18_rightClick(){

        /*
        1. Go	to	https://the-internet.herokuapp.com/context_menu
        2. Right	click	to	the	box.
        3. Alert	will	open.
        4. Accept	alert
        No	assertion	needed	for	this	practice
         */
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions = new Actions(driver);
        actions.contextClick(box).perform();

        Alert alert = driver.switchTo().alert();
        BrowserUtils.Wait(2);
        alert.accept();

    }

}
