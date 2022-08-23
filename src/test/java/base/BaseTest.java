package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wdWait ;
    public static Action actions ;
    public JavascriptExecutor js ;



    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://www.mozzartbet.com/sr#/");

        js = (JavascriptExecutor) driver ;
      //  actions = new Action(driver);
        }

    /*    @After
    public void tearDown(){
        driver.quit();
    }*/
}
