package test;

import base.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.*;



public class LoginTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage ;



    @Before
    public void setUpLoginTest(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }
    @Test
    public void successfulLogin() throws InterruptedException {
        loginPage.userFieldSendKeys("otp1");
        loginPage.passFieldSendKeys(" ");
        loginPage.okButtonClick();
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Prijava korisnika";
       Assert.assertEquals(ExpectedTitle, ActualTitle);
      //   System.out.println(“ Assert passed ”);
        Thread.sleep(20000);


      // mainPage.logoutButtonClick();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
