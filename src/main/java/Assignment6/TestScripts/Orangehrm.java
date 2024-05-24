package Assignment6.TestScripts;

import Assignment6.Common.Asserter;
import Assignment6.Common.Generic;
import Assignment6.Common.LogUtil;
import Assignment6.Common.ReportUtility;
import Assignment6.DataProvider.DataPro;
import Assignment6.Pages.HomePage;
import Assignment6.Pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class Orangehrm extends Generic {

    //private static final Logger log = LogManager.getLogger(Orangehrm.class);

    @Test(priority = 1,dataProvider="InvalidLoginData",dataProviderClass = DataPro.class)
    public void validateInvalidLogin(String user,String pass) throws IOException {
        LogUtil.inform("Waiting for webpage to load");
        test=eReports.createTest("Validating Invalid Login");
        asserter=new Asserter(test);
        LoginPage loginPage1 = new LoginPage(driver);
        asserter.assertEquals(driver.getTitle(),"OrangeHRM","Correct title not found");
        loginPage1.enterUserCredentials(user,pass);
        LogUtil.warning("Taking Too much time to load");
        asserter.assertTrue(loginPage1.isInvalidErrorMsgDisplayed(),"Invalid Login error Displayed#"+getScreenshot());
        asserter.assertAll();
    }
    @Test(dataProvider="DataExcel",dataProviderClass = DataPro.class,enabled=false)
    public void validateInvalidLoginExcel(Map<String,String> up) throws IOException {
        test=eReports.createTest("Validating Invalid Login Using Excel");
        LoginPage loginPage1 = new LoginPage(driver);
        loginPage1.enterUserCredentials(up.get("Username"),up.get("Password"));
        asserter.assertTrue(loginPage1.isInvalidErrorMsgDisplayed(),"Error Message Validated#"+getScreenshot());
        asserter.assertAll();
    }
    @Test(priority = 2)
    public void validateValidLogin() throws IOException {
        test=eReports.createTest("Validating valid login credentials");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserCredentials("Admin","admin123");
        HomePage homePage = new HomePage(driver);
        if(homePage.isDashboardVisible()){
            ReportUtility.pass(test,"Successfull Login",getScreenshot());
            LogUtil.inform("Currently in Home Page");
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
