package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wdWait ;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("https://www.mozzartbet.com/sr#/login");
        }


    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
