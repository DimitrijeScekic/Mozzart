package page;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static base.BaseTest.driver;
import static base.BaseTest.wdWait;
import static java.lang.Thread.sleep;

public class PageHelper {

    private static final String ALLOWED_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void selectRandomDayFromList() {
        List<WebElement> days = driver.findElements(By.xpath("//div[@class='form__selectv2__selected-item']"));
        int maxDays = days.size();
        Random random = new Random();
        int randomDay = random.nextInt(maxDays);
        days.get(randomDay).click();
    }

    public static String randomPrivredniSubjekat() {
        String randomElement = null;
        Random rand = new Random();
        List<String> givenList = Arrays.asList("MAXI", "LIDL", "MONA", "DELHAIZE", "TELEKOM", "ZASTAVA", "OSA Racunarski Inzenjering", "BeoLab", "TANJUG", "Gordic doo");

        int numberOfElements = 10;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            randomElement = givenList.get(randomIndex);
        }
        return randomElement;
    }

    public static String randomMesto() {
        String randomElement = null;
        Random rand = new Random();
        List<String> givenList = Arrays.asList("Beograd", "Novi Sad", "Nis", "Kragujevac", "Indjija", "Kikinda", "Paracin", "Novi Pazar", "Kraljevo", "Subotica");

        int numberOfElements = 10;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            randomElement = givenList.get(randomIndex);
        }
        return randomElement;
    }

    public static String randomAdresa() {
        String randomElement = null;
        Random rand = new Random();
        List<String> givenList = Arrays.asList("nova 2", "karadjordjeva 12", "visnjicka 90", "rige od Fere 45", "kajmakcalanska 105", "cvijiceva 23", "ruzveltova 78", "cara Lazara 59", "francuska 39", "zaplanjska bb");

        int numberOfElements = 10;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            randomElement = givenList.get(randomIndex);
        }
        return randomElement;
    }

    public static String randomIme() {
        String randomElement = null;
        Random rand = new Random();
        List<String> givenList = Arrays.asList("Zoran", "Dragan", "Milan", "Dobrivoje", "Marinko", "Ivan", "Damjan", "Dalibor", "Savo", "Miroslav");

        int numberOfElements = 10;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            randomElement = givenList.get(randomIndex);
        }
        return randomElement;
    }

    public static String randomPrezime() {
        String randomElement = null;
        Random rand = new Random();
        List<String> givenList = Arrays.asList("Cvijic", "Petric", "Borovic", "Popovic", "Jovanovic", "Ivanovic", "Jovic", "Ristic", "Goluza", "Logar");

        int numberOfElements = 10;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            randomElement = givenList.get(randomIndex);
        }
        return randomElement;
    }

    public static String randomRocnost() {
        String randomElement = null;
        Random rand = new Random();
        List<String> givenList = Arrays.asList("18", "24", "36", "48", "60");

        int numberOfElements = 5;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            randomElement = givenList.get(randomIndex);
        }
        return randomElement;
    }

    public static String randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return String.valueOf(randomNum);
    }

    public static int randIntExcept(int min, int max, List<Integer> values) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        boolean pass = true;
        for (int i = 0; i < values.size(); i++) {
            if (randomNum == values.get(i))
                pass = false;
        }
        while (pass == false) {
            randomNum = rand.nextInt((max - min) + 1) + min;
            pass = true;
            for (int i = 0; i < values.size(); i++) {
                if (randomNum == values.get(i))
                    pass = false;
            }

        }
        return randomNum;
    }

    public static String randDateTotal() {
        return randDate(1, 31, 1, 12, 1990, 2020);

    }

    public static String randDateControlYear(int yearMin, int yearMax) {
        return randDate(1, 31, 1, 12, yearMin, yearMax);

    }

    public static String randDate(int minDay, int maxDay, int minMonth, int maxMonth, int minYear, int maxYear) {
        int day;
        String dayS = "";
        int month;
        String monthS = "";
        int year;

        year = Integer.parseInt(randInt(minYear, maxYear));
        month = Integer.parseInt(randInt(minMonth, maxMonth));
        if (month < 10)
            monthS = "0" + month;
        else
            monthS = month + "";
        if (month == 2 && maxDay > 28)
            if (year % 4 == 0)
                maxDay = 29;
            else
                maxDay = 28;
        day = Integer.parseInt(randInt(minDay, maxDay));
        if (day < 10)
            dayS = "0" + day;
        else
            dayS = day + "";
        return monthS.toString() + "-" + dayS.toString() + "-" + year;

    }

    public static int randIntFromList(List<Integer> list) {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }

    public static int randIntFromMap(Map<Integer, Integer> map) {
        Random r = new Random();
        Set<Integer> values = map.keySet();
        int size = values.size();
        int item = r.nextInt(size);
        int i = 0;
        for (Object obj : values) {
            if (i == item) {
                int value = (int) obj;
                return value;
            }
            i = i + 1;
        }
        return 0;
    }

    public static String randomFutureDate() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy HH:mm");
        Calendar cal = Calendar.getInstance();
        String str_date1 = "June-27-2020 02:10";
        String str_date2 = "June-27-2029 02:10";

        cal.setTime(formatter.parse(str_date1));

        cal.setTime(formatter.parse(str_date2));

        return
                formatter.format(cal.getTime());
    }

    public static void randomDate() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String str_date1 = "17-June-07 02:10:15";
        String str_date2 = "27-June-07 02:10:20";

        cal.setTime(formatter.parse(str_date1));
        Long value1 = cal.getTimeInMillis();

        cal.setTime(formatter.parse(str_date2));
        Long value2 = cal.getTimeInMillis();

        long value3 = (long) (value1 + Math.random() * (value2 - value1));
        cal.setTimeInMillis(value3);
        System.out.println(formatter.format(cal.getTime()));
    }

    public static void scroolToTheTopOfThePage()
            throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll up till the top of the page
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }

    public static void scroolToTheBottomOfThePage()
            throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll up till the top of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static void rightMouseClick(WebElement element) {
    Actions actions = new Actions(driver);
    WebElement elementLocator = driver.findElement((By) element);
actions.contextClick(elementLocator).

    perform();
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

    public  String generateRandomEmail(int length) {
        String allowedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" + "@$!%*#?&";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp + "@testdata.com";
        return email;
    }

    public String randomString(int len) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        }
        return sb.toString();
    }

    public void scroolToElement(WebElement element)
            throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        sleep(2000);
        wdWait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void scrollUnderElement(By element) throws InterruptedException {
        System.out.println("Scrolling ...");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
    }

    public void replaceText(By element, String value) throws Exception {
        wdWait.until(ExpectedConditions.elementToBeSelected(element));
        WebElement webElement = driver.findElement(element);

        if (webElement == null) {
            throw new Exception("web element nije pronadjen");
        }

        // select all and replace
        driver.findElement(element).sendKeys(Keys.chord(Keys.CONTROL, "a"), value);

    }

    public void sendEmptyKeys(By element) throws Exception {
        wdWait.until(ExpectedConditions.elementToBeSelected(element));
        driver.findElement(element).sendKeys(""); // input text
    }

    /**
     * useful when field cannot stay empty never (spinners for example)
     *
     * @param element
     * @param value
     * @throws Exception
     */
    public void selectAndOverwrite(By element, String value) throws Exception {
        wdWait.until(ExpectedConditions.elementToBeSelected(element));
        driver.findElement(element).sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
    }

    private String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void focus() {
        driver.switchTo().defaultContent();
        System.err.println("JSL INFO: Focusing main screen. " + getCurrentTime());
    }

}
