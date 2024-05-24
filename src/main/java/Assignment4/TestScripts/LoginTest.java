package Assignment4.TestScripts;

import Assignment3.GenericExcel;
import Assignment4.Common.GenericBase;
import Assignment4.PageObjects.HomePage;
import Assignment4.PageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends GenericBase {

    @Test(priority = 1)
    public void validateInvalidLogin(){
        LoginPage loginPage1 = new LoginPage(driver);
        loginPage1.enterUserCredentials("Rohit Sharma","hitman101");
        if(loginPage1.isInvalidErrorMsgDisplayed()){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }driver.close();
    }
    @Test(priority = 2)
    public void validateValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserCredentials("Admin","admin123");
        HomePage homePage = new HomePage(driver);
        if(homePage.isDashboardVisible()){
            System.out.println("Passed");
            homePage.clickPim();
            homePage.clickLeave();
            homePage.clickMyInfo();
            back();
            homePage.logout();
            tearDown();
        }else{
            System.out.println("Failed");
        }
    }
}
