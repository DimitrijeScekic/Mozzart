package test;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;
//import static page.PageHelper.scroolToElement;


public class NewUserRegistrationTest extends BaseTest {

    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    PageHelper pageHelper;


    @Before
    public void setUpLoginTest() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
        registrationPage = new RegistrationPage();
        pageHelper = new PageHelper();
    }

    @Test
    public void newUserSuccessRegistration() throws InterruptedException {
        String username = "Tester1";
        String email = "tester1@gmail.com";
        String password1 = "Testnipass1!";

        mainPage.sacuvajZatvoriButtonClick();
        mainPage.popUpNotificationCancelling();
        mainPage.logoButtonClick();
        mainPage.registrujSeButtonClick();
       // registrationPage.setUsernameField(pageHelper.randomString(8));
        registrationPage.setUsernameField(username);
       // registrationPage.setEmailAddressField(pageHelper.generateRandomEmail(6));
        registrationPage.setEmailAddressField(email);
        String password = pageHelper.generatePassword();
       // registrationPage.setPassswordField(password);
       // registrationPage.setConfirmPasswordField(password);
        registrationPage.setPassswordField(password1);
        registrationPage.setConfirmPasswordField(password1);

        registrationPage.daljeButtonClick();

        registrationPage.setFirstNameField(PageHelper.randomIme());
        registrationPage.setLastNameField(PageHelper.randomPrezime());
        // registrationPage.selectRandomDayFromList();
        registrationPage.selectPromoCheckBox();

        registrationPage.setOtvoriNalogButton();

/*

        String privredniSubjekat = pageHelper.randomPrivredniSubjekat();
        String mesto = pageHelper.randomMesto();
        String adresa = pageHelper.randomAdresa();
        String ime = pageHelper.randomPrezime();
        String prezime = pageHelper.randomAdresa();
        String rocnost = pageHelper.randomRocnost();
        String dvoBroj = pageHelper.randInt(1, 98);
        String troBroj = pageHelper.randInt(100, 998);
        String petBroj = pageHelper.randInt(10000, 99998);
        String sestBroj = pageHelper.randInt(100000, 999998);
        String osmBroj = pageHelper.randInt(10000000, 99999998);
        String devetBroj = pageHelper.randInt(100000000, 999999998);

   */

    }





   /* @After
    public void tearDown() {
        driver.quit();
    }*/
}
