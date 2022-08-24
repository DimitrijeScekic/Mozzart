package page;

import base.BaseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;

public class RegistrationPage extends BaseTest {

   @FindBy( id="username")
    WebElement usernameField;
    @FindBy( id="email_address")
    WebElement emailAddressField;
    @FindBy( id="password")
    WebElement passwordField;
    @FindBy( id="confirm_password")
    WebElement confirmPasswordField;
    @FindBy( xpath="//button[normalize-space()='Dalje']")
    WebElement daljeButton;
    @FindBy( id ="firstName")
    WebElement firstNameField;
    @FindBy(xpath ="//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy( xpath="//div[@class='form__selectv2__selected-item'][normalize-space()='11']")
    WebElement dateDropDownMenu;

    @FindBy( xpath="//label[@name='activePromo']//span[@class='checkmark']")
    WebElement promoCheckBox;

    @FindBy( xpath="//button[normalize-space()='Otvori nalog']")
    WebElement otvoriNalogButton;

    @FindBy( xpath="//strong[normalize-space()='Ulogujte se']")
    WebElement ulogujteSeButton;


    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }


    public void setUsernameField(String username){
        wdWait.until(ExpectedConditions.visibilityOf(usernameField)).clear();
        usernameField.sendKeys(username);
    }
    public void setEmailAddressField(String email){
        wdWait.until(ExpectedConditions.visibilityOf(emailAddressField)).clear();
        emailAddressField.sendKeys(email);
    }
    public void setPassswordField(String password){
        wdWait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(password);
    }
    public void setConfirmPasswordField(String password){
        wdWait.until(ExpectedConditions.visibilityOf(confirmPasswordField)).clear();
        confirmPasswordField.sendKeys(password);
    }

    public void daljeButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(daljeButton)).click();
    }

    public void setFirstNameField(String firstname){
        String js = "arguments[0].setAttribute('value','"+firstname+"')" ;
        ((JavascriptExecutor) driver).executeScript(js, firstNameField);

    }
    public void setLastNameField(String lastname){
        String js = "arguments[0].setAttribute('value','"+lastname+"')" ;
        ((JavascriptExecutor) driver).executeScript(js, lastNameField);
    }

    public void selectPromoCheckBox(){
        wdWait.until(ExpectedConditions.elementToBeClickable(promoCheckBox)).click();
    }

    public void selectRandomDayFromList() {
        Select days = new Select (dateDropDownMenu);
        List<WebElement> options = days.getOptions();
        int maxDays = options.size();
        Random random = new Random();
        int randomDay = random.nextInt(maxDays);
        days.selectByVisibleText((String.valueOf(randomDay)));
    }

    public void setOtvoriNalogButton() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", otvoriNalogButton);
        }

    public void ulogujteSeButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(ulogujteSeButton)).click();
    }

    public String generatePassword() {
        int length = 8;
        String symbol = "-/.^&*_!@%=+>)";
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String finalString = cap_letter + small_letter +
                numbers + symbol;

        Random random = new Random();

        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            password[i] =
                    finalString.charAt(random.nextInt(finalString.length()));

        }
        return password.toString();
    }
}