package test;

import base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.BettingPage;
import page.LoginPage;
import page.MainPage;


public class TicketCreationTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage ;
    BettingPage bettingPage ;



  @BeforeMethod
    public void setUpLoginTest(){
       loginPage = new LoginPage();
       mainPage = new MainPage();
       bettingPage = new BettingPage();
    }

@Test
    public void createTicket() throws InterruptedException {
        mainPage.sacuvajZatvoriButtonClick();
    Thread.sleep(2000);
        mainPage.popUpNotificationCancelling();
        mainPage.logoButtonClick();
        mainPage.setKorisnickoImeField("Dimitrije.00");
        mainPage.setLozinkaField("Dimitrije.00!");
        mainPage.loginOkButtonClick();
        mainPage.kladjenjeButtonClick();
        bettingPage.setTriDanaOpcija();
        bettingPage.setFudbalOpcija();
        bettingPage.selectRandomCompetitionFromList();
        Thread.sleep(2000);
        bettingPage.selectRandomQuotes(5);
       // bettingPage.uplataButtonClick();
        bettingPage.setUplataField("100");
        bettingPage.uplatiButtonClick();
        Thread.sleep(2000);
        bettingPage.fastTicketButtonClick();
        String code = bettingPage.fastTicketCodeField.getText();
        System.out.println(code);
        bettingPage.closeButtonClick();

    }
}
