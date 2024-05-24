package Day23.Commons.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObjectBase {
    @FindBy(xpath = "/html/body/div//p[1]")
    private WebElement lbl_user;

    @FindBy(xpath = "/html/body/div//p[2]")
    private WebElement lbl_pass;


    @FindBy(name = "username")
    private WebElement txt_userName;

    @FindBy(name = "password")
    private WebElement txt_passWord;

    @FindBy(xpath = "//button")
    private WebElement btn_login;

    @FindBy(xpath = "//div[@role='alert']//div[1]//p")
    private WebElement lbl_errorMsg;

    /**
     *
     * @param driver
     */
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    /**
     * This method fetches the valid credentials displayed on the login page.
     */
    public void getValidCredentials()
    {
        lbl_user.getText();
        lbl_pass.getText();
    }

    /**
     * This method enters the username and password
     * @param userName
     * @param password
     */
    public void enterUserCredentials(String userName,String password){
//        txt_userName.sendKeys(userName);
//        txt_passWord.sendKeys(password);
//        btn_login.submit();
        typeText(txt_userName,userName);
        typeText(txt_passWord,password);
        click(btn_login);
    }
    public boolean isInvalidErrorMsgDisplayed(){
//        return lbl_errorMsg.isDisplayed();
        return isElementDisplayed(lbl_errorMsg);
    }
}
