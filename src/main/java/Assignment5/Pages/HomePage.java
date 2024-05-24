package Assignment5.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObjectsBase {
    WebDriver driver;

    @FindBy(xpath = "//div[@id='app']//h6")
    private WebElement heading_dashboard;

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")
    private WebElement list_pim;

    @FindBy(xpath = "//div[@id='app']//ul//li[3]//span")
    private WebElement list_leave;

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a")
    private WebElement list_myInfo;

    @FindBy(xpath = "//div[@id='app']//header//ul//img")
    private WebElement img_profile;

    @FindBy(xpath = "//div[@id='app']//header//ul//li[4]")
    private WebElement list_logout;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isDashboardVisible(){
        //return heading_dashboard.isDisplayed();
        return isElementDisplayed(heading_dashboard);//common action method
    }
    public void clickPim(){
        click(list_pim);//common action method
    }
    public void clickLeave(){
        click(list_leave);//common action method
    }
    public void clickMyInfo(){
        click(list_myInfo);//common action method
    }
    public void logout(){
        click(img_profile);//common action method
        click(list_logout);//common action method
    }
}
