package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class RegistrationPage extends BaseTest {



        LocalDate currentdate = LocalDate.now();
        int currentDay = currentdate.getDayOfMonth();
        int currentMonth = currentdate.getMonthValue();
        int currentYear = currentdate.getYear();

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

    @FindBy( xpath="//button[@type='submit']")
    WebElement otvoriNalogButton;


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
      //  dateDropDownMenu.click();
        Select days = new Select (dateDropDownMenu);
   //     wdWait.until(ExpectedConditions
      //          .visibilityOf(driver.findElement(By.xpath("//div[@class='form__selectv2__selected-item'][normalize-space()='11']"))));

     //  List<WebElement> days = driver.findElements(By.xpath("//div[@class='form__selectv2__selected-item'][normalize-space()='11']"));
        List<WebElement> options = days.getOptions();
        int maxDays = options.size();
        Random random = new Random();
        int randomDay = random.nextInt(maxDays);
        days.selectByVisibleText((String.valueOf(randomDay)));
       // options.get(randomDay).click();
    }

    public void setOtvoriNalogButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(otvoriNalogButton)).click();
    }

  /*  public void vrstaStatusaSelect( String value){
        wdWait.until(ExpectedConditions.visibilityOf(statusMenu));
        Select vrstaKlijenta = new Select (statusMenu);
        vrstaKlijenta.selectByValue(value);
    }


    public void sacuvajZahtevButtonClick() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        sleep(4000);
        wdWait.until(ExpectedConditions.elementToBeClickable(sacuvajZahtevButton)).click();
    }
      public void vrstaKlijentaDropDownSelect( String value) {
        WebElement select = driver.findElement(By.id("gender"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if ("Novi".equals(option.getText()))
                option.click();
        }
    }

    */




}