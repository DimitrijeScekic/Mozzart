package test;

import base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import page.*;

public class LoginTest extends BaseTest{

    MainPage mainPage;
    LoginPage loginPage ;
    RegistrationPage registrationPage ;

    @BeforeMethod
    public void setUpLoginTest(){
    loginPage = new LoginPage();
    mainPage = new MainPage();
    registrationPage = new RegistrationPage();

    }

      @Test
        public void testTC_Login001_UsernameCorrectPassCorrect() throws InterruptedException {
                mainPage.sacuvajZatvoriButtonClick();
                Thread.sleep(2000);
                mainPage.popUpNotificationCancelling();
                mainPage.logoButtonClick();
                mainPage.registrujSeButtonClick();
                registrationPage.ulogujteSeButtonClick();
                loginPage.setUsernameField("dimitrije.00");
                loginPage.setPasswordField("Dimitrije.00!");
                Thread.sleep(2000);
                Actions action = new Actions(driver);
                action.sendKeys(Keys.ENTER).build().perform();

        }

@Test
    public void testTC_Login002_UsernameEmptyPassEmpty() throws InterruptedException,NullPointerException {
            mainPage.sacuvajZatvoriButtonClick();
            Thread.sleep(4000);
            mainPage.popUpNotificationCancelling();
            mainPage.logoButtonClick();
            mainPage.registrujSeButtonClick();
            registrationPage.ulogujteSeButtonClick();
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
            String ExpectedTextMessageUsername = "Polje Korisničko ime je obavezno." ;
            Assert.assertEquals(ExpectedTextMessageUsername, loginPage.usernameEmptyFieldErrorMessage.getText());
            String ExpectedTextMessagePassword = "Polje Lozinka je obavezno." ;
            Assert.assertEquals(ExpectedTextMessagePassword, loginPage.passwordEmptyFieldErrorMessage.getText());

    }

 @Test
    public void testTC_Login003_UsernameCorrectPassEmpty() throws InterruptedException,NullPointerException  {

            mainPage.sacuvajZatvoriButtonClick();
            Thread.sleep(4000);
            mainPage.popUpNotificationCancelling();
            mainPage.logoButtonClick();
            mainPage.registrujSeButtonClick();
            registrationPage.ulogujteSeButtonClick();
            loginPage.setUsernameField("dimitrije.00");
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
            String ExpectedTextMessagePassword = "Polje Lozinka je obavezno." ;
            Assert.assertEquals(ExpectedTextMessagePassword, loginPage.passwordEmptyFieldErrorMessage.getText());

    }

@Test
    public void testTC_Login004_UsernameEmptyPassCorrect() throws InterruptedException,NullPointerException  {

            mainPage.sacuvajZatvoriButtonClick();
            Thread.sleep(4000);
            mainPage.popUpNotificationCancelling();
            mainPage.logoButtonClick();
            mainPage.registrujSeButtonClick();
            registrationPage.ulogujteSeButtonClick();
            loginPage.setPasswordField("Dimitrije.00!");
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
            String ExpectedTextMessageUsername = "Polje Korisničko ime je obavezno." ;
            Assert.assertEquals(ExpectedTextMessageUsername, loginPage.usernameEmptyFieldErrorMessage.getText());

    }

   @Test
    public void testTC_Login005_UsernameIncorrectPassIncorrect() throws InterruptedException,NullPointerException  {

            mainPage.sacuvajZatvoriButtonClick();
            Thread.sleep(4000);
            mainPage.popUpNotificationCancelling();
            mainPage.logoButtonClick();
            mainPage.registrujSeButtonClick();
            registrationPage.ulogujteSeButtonClick();
            loginPage.setUsernameField("Incorrect");
            loginPage.setPasswordField("Incorrect24!");
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
            String ExpectedTextMessage = "Pogrešno korisničko ime ili lozinka" ;
            Assert.assertEquals(ExpectedTextMessage, loginPage.usernameWrongInputErrorMessage.getText());
            Assert.assertEquals(ExpectedTextMessage, loginPage.passwordWrongInputErrorMessage.getText());

    }

 @Test
    public void testTC_Login006_UsernameIncorrectPassEmpty() throws InterruptedException,NullPointerException  {

            mainPage.sacuvajZatvoriButtonClick();
            Thread.sleep(4000);
            mainPage.popUpNotificationCancelling();
            mainPage.logoButtonClick();
            mainPage.registrujSeButtonClick();
            registrationPage.ulogujteSeButtonClick();
            loginPage.setUsernameField("Incorrect");
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
            String ExpectedText = "Polje Lozinka je obavezno." ;
            Assert.assertEquals(ExpectedText, loginPage.passwordEmptyFieldErrorMessage.getText());

    }

@Test
    public void testTC_Login007_UsernameEmptyPassIncorrect() throws InterruptedException,NullPointerException  {

            mainPage.sacuvajZatvoriButtonClick();
            Thread.sleep(4000);
            mainPage.popUpNotificationCancelling();
            mainPage.logoButtonClick();
            mainPage.registrujSeButtonClick();
            registrationPage.ulogujteSeButtonClick();
            loginPage.setPasswordField("Incorrect24!");
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
            String ExpectedTextMessageUsername = "Polje Korisničko ime je obavezno." ;
            Assert.assertEquals(ExpectedTextMessageUsername, loginPage.usernameEmptyFieldErrorMessage.getText());

    }
    }


