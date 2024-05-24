package Assignment5.TestScripts;

import Assignment5.Commons.Generic;
import Assignment5.Commons.ReportUtility;
import Assignment5.DataProvider.DataPro;
import Assignment5.Pages.HomePage;
import Assignment5.Pages.LoginPage;






import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static Assignment5.Commons.Generic.eReports;

public class Orangehrm extends Generic {
    @Test(priority = 1,dataProvider="InvalidLoginData",dataProviderClass = DataPro.class,enabled = false)
    public void validateInvalidLogin(String user,String pass) throws IOException {
        test=eReports.createTest("Validating Invalid Login");
        LoginPage loginPage1 = new LoginPage(driver);
        loginPage1.enterUserCredentials(user,pass);
        if(loginPage1.isInvalidErrorMsgDisplayed()){
            //test.pass("Successfully validated the display of error message", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot().replace(REPORT_PATH+"\\","")).build());
            ReportUtility.pass(test,"Successfully validated the display of error message",getScreenshot());
        }else{
            ReportUtility.fail(test,"Failed to validate error message");
            //test.fail("Failed to validate error message",MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot().replace(REPORT_PATH+"\\","")).build());
        }
    }
    @Test(dataProvider="DataExcel",dataProviderClass = DataPro.class)
    public void validateInvalidLoginExcel(Map<String,String> up) throws IOException {
        test=eReports.createTest("Validating Invalid Login Using Excel");
        LoginPage loginPage1 = new LoginPage(driver);
        loginPage1.enterUserCredentials(up.get("Username"),up.get("Password"));
        if(loginPage1.isInvalidErrorMsgDisplayed()){
            ReportUtility.pass(test,"Successfully validated the display of error message");
        }else{
            ReportUtility.fail(test,"Failed to validate error message");
        }
    }
    @Test(priority = 2)
    public void validateValidLogin() throws IOException {
        test=eReports.createTest("Validating valid login credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserCredentials("Admin","admin123");
        HomePage homePage = new HomePage(driver);
        if(homePage.isDashboardVisible()){
            ReportUtility.pass(test,"Successfull Login",getScreenshot());
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
