package test;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.*;

public class NewUserRegistrationTest extends BaseTest {

    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeTest
    public void setUpLoginTest() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
        registrationPage = new RegistrationPage();
          }

    @Test
    public void newUserSuccessRegistration() throws InterruptedException {
        String username = "Tester1";
        String email = "tester1@gmail.com";
        String password1 = "Testnipass1!";
        Actions action = new Actions(driver);

        mainPage.sacuvajZatvoriButtonClick();
        mainPage.popUpNotificationCancelling();
        mainPage.logoButtonClick();
        mainPage.registrujSeButtonClick();
        registrationPage.setUsernameField(username);
        registrationPage.setEmailAddressField(email);
        String password = registrationPage.generatePassword();
        registrationPage.setPassswordField(password1);
        registrationPage.setConfirmPasswordField(password1);
        registrationPage.daljeButtonClick();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById('firstName').setAttribute('value', 'Milan');");
        Thread.sleep(2000);
        jse.executeScript("document.getElementById('lastName').setAttribute('value', 'Scekic');");
        registrationPage.selectPromoCheckBox();
        Thread.sleep(2000);

        action.sendKeys(Keys.ENTER).build().perform();

    }
}
