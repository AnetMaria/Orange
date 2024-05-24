package Day20.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
    //identifying all the elements in the page
    @FindBy(name = "email")
    private WebElement txt_emailAddress;    //of type textbox//giving unique variable for each element that can be accessed only in this class

    @FindBy(xpath = "//input[@name='password']")
    private WebElement txt_password;   //of type textbox//give the same name as the one in webpage for ease of identification

    @FindBy(xpath = "//form[@action='/login']//button[1]")
    private WebElement btn_login;    //of type button

    @FindBy(xpath = "//form[@action='/login']//p[contains(text(),'Your email or password is incorrect!')]")
    private WebElement lbl_errorMsg;

    //performing actions on the elements
    public void enterUserCredentials(String userName,String password){
        txt_emailAddress.sendKeys(userName);
        txt_password.sendKeys(password);
        btn_login.submit();
    }

    public boolean isInvalidErrorMsgDisplayed(){
        return lbl_errorMsg.isDisplayed();
    }
}
