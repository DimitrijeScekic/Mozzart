package page;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BettingPage extends BaseTest {


    @FindBy(xpath = "//div[@class='fast-ticket-wrapper']/p")
    public WebElement fastTicketCodeField;
    @FindBy(xpath = "//li[normalize-space()='3 dana']")
    WebElement triDanaOpcija;
    @FindBy(xpath = "//span[@class='name main'][normalize-space()='Fudbal']")
    WebElement fudbalOpcija;
    @FindBy(xpath = "//a[@class='payin-btn']")
    WebElement uplataButton;
    @FindBy(xpath = "//input[@id='bettingAmount']")
    WebElement uplataField;
    @FindBy(xpath = "//button[@id='pay-ticket']")
    WebElement uplatiButton;
    @FindBy(xpath = "//a[@class='fast-ticket pointer']")
    WebElement fastTicketButton;
    @FindBy(xpath = "//button[@class='button close']")
    WebElement closeButton;

    public BettingPage() {
        PageFactory.initElements(driver, this);
    }


    public void setTriDanaOpcija() {
        wdWait.until(ExpectedConditions.elementToBeClickable(triDanaOpcija)).click();
    }

    public void setFudbalOpcija() {
        wdWait.until(ExpectedConditions.elementToBeClickable(fudbalOpcija)).click();
    }

    public void selectRandomCompetitionFromList() throws InterruptedException {

        List<WebElement> competition = driver.findElement(By.xpath("//li[@class='main-item active all-active']")).findElements(By.className("counter"));
        int max = competition.size();
        ArrayList<WebElement> my_list = new ArrayList<WebElement>();

        for (int i = 0; i < max; i++) {
            int m;
            try {
                String counter = competition.get(i).getText();
                m = Integer.parseInt(counter);
                if (m >= 4) {
                    my_list.add(competition.get(i));
                }
            } catch (NumberFormatException e) {
                m = 0;
            }
        }
        try {
            Random random = new Random();
            int randomCompetition = random.nextInt(my_list.size());
            my_list.get(randomCompetition).click();
        } catch (IllegalArgumentException illegalArgumentException) {
            String description = String.join("\n",
                    "The provided list is empty (size = 0)."
            );
            throw new RuntimeException(description, illegalArgumentException) {
            };
        }
    }

    public void selectRandomQuotes(int num)  {

       WebElement prvi = driver.findElement(By.className("competition"));
       WebElement drugi = prvi.findElement(By.className("part2"));
       List<WebElement> elements = drugi.findElements(By.className("part2wrapper"));

        int max = elements.size();
        for (int i = 0; i < max; i++) {
            Random random = new Random();
              int randomCompetition = random.nextInt(max);
          try {
              WebElement quote = elements.get(randomCompetition).findElement(By.tagName("span"));
               Actions action = new Actions(driver);
               action.click(quote).perform();
               Thread.sleep(1000);

          }
          catch (StaleElementReferenceException | InterruptedException e){

          }

        }
    }

    public void uplataButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(uplataButton)).click();
    }
    public void setUplataField(String iznos){
        wdWait.until(ExpectedConditions.visibilityOf(uplataField)).clear();
        uplataField.sendKeys(iznos);
    }
    public void uplatiButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(uplatiButton)).click();
    }

    public void fastTicketButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(fastTicketButton)).click();
    }
    public void closeButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
    }

    }





