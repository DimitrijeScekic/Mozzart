package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;


public class MainPage extends BaseTest {


    @FindBy(xpath="//*[@id=\"onesignal-slidedown-cancel-button\"]")
    WebElement popUpNotificationCancelButton;
    @FindBy(xpath="//article[@class='content']//a[@class='logo mozzart_sr']")
    WebElement logoButton;

    @FindBy(xpath="//button[@class='accept-button']")
    WebElement sacuvajZatvoriButton;
    @FindBy(linkText="Registruj se")
    WebElement registrujSeButton;


    public MainPage() { PageFactory.initElements(driver,this);}

    public void popUpNotificationCancelling() {
        wdWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]"))));
        driver.findElement(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")).click();
    }

    public void logoButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(logoButton)).click();
    }

    public void sacuvajZatvoriButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(sacuvajZatvoriButton)).click();
    }
    public void registrujSeButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(registrujSeButton)).click();
    }
}
