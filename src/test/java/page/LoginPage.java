package page;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BaseTest {

    @FindBy(xpath = "//span[normalize-space()='Polje Lozinka je obavezno.']")
   public WebElement passwordEmptyFieldErrorMessage;
    @FindBy(xpath = "//div[@name='username']//span[@class='form__helper-text error'][contains(text(),'Pogrešno korisničko ime ili lozinka')]")
   public WebElement usernameWrongInputErrorMessage;
    @FindBy(xpath = "//div[@name='password']//span[@class='form__helper-text error'][contains(text(),'Pogrešno korisničko ime ili lozinka')]")
   public WebElement passwordWrongInputErrorMessage;
    @FindBy(xpath = "//span[contains(text(),'Polje Korisničko ime je obavezno.')] ")
   public  WebElement usernameEmptyFieldErrorMessage;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Prijavite se']")
    WebElement logInButton;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    public void setUsernameField(String userName) {
        wdWait.until(ExpectedConditions.visibilityOf(usernameField)).clear();
        usernameField.sendKeys(userName);
    }

    public void setPasswordField(String pass) {
        wdWait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(pass);
    }

    public Object logInButtonClick() {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
        } catch (NoSuchElementException e) {
            System.out.println("Handled NoSuchElementException");
        }


        return null;
    }

    public void getList (WebElement element) {
        List<WebElement> myElementList = driver.findElements((By) element);
        }

}
