package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {
    public LoginPage() { PageFactory.initElements(driver, this);}

    @FindBy(id="ctl05_Panel_txtUserName_I")
    WebElement userField;
    @FindBy(id="ctl05_Panel_txtPasswd_I")
    WebElement passField;
    @FindBy(id="ctl05_Panel_Ok")
    WebElement OkButton;

  /*  public void userFieldClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(user)).click();
    }*/
    public void userFieldSendKeys(String userName){
        wdWait.until(ExpectedConditions.visibilityOf(userField)).clear();
        userField.sendKeys(userName);
    }
    public void passFieldSendKeys(String pass){
        wdWait.until(ExpectedConditions.visibilityOf(passField)).clear();
        passField.sendKeys(pass);
    }

    public void okButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
    }


}
