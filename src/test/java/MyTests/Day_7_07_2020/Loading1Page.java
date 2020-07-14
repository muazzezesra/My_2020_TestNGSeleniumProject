package MyTests.Day_7_07_2020;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class Loading1Page {

    public Loading1Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "pwd")
    public WebElement password;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement SubmitButton;

    @FindBy(xpath = "//label[.=' Remember me']")
    public WebElement rememberMeButton;

    @FindBy(id = "flash")
    public WebElement errorMessage;

    @FindBy(id = "loading")
    public WebElement loading;

}
