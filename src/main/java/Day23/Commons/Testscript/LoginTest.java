package Day23.Commons.Testscript;

import Day23.Commons.Asserter;
import Day23.Commons.GenericBase;
import Day23.Commons.LogUtil;
import Day23.Commons.Pages.LoginPage;
import Day23.Commons.Pages.HomePage;
import Day23.Commons.DataProvider.dp_Login;
import Day23.Commons.ReportUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import static Day23.Commons.Constants.ApplicationConstants.*;

public class LoginTest extends GenericBase {

    @Test(priority = 1,dataProvider="InvalidLoginData",dataProviderClass = dp_Login.class)
    public void validateInvalidLogin(String user,String pass) throws IOException {
        LogUtil.inform("Testing Invalid Login");
        test=eReports.createTest("Validating Invalid Login");
        //soft assert
        SoftAssert Assert = new SoftAssert();
        LoginPage loginPage1 = new LoginPage(driver);

        //Validating title of the page----old assert
        //Assert.assertEquals(driver.getTitle(),"OrangHRM","The title is not matching");
        LogUtil.inform("Currently in the Login Page");
        //Custom assert
        //asserter=new Asserter(test);//calling the constructor in the Asserter class
        //asserter.assertEquals(driver.getTitle(),"OrangHRM","The title is not matching#"+getScreenshot());//with screenshot
        //asserter.assertEquals(driver.getTitle(),"OrangHRM","The title is not matching");//without screenshot
        loginPage1.enterUserCredentials(user,pass);
//        if(loginPage1.isInvalidErrorMsgDisplayed()){
//            //test.pass("Successfully validated the display of error message", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot().replace(REPORT_PATH+"\\","")).build());
//            ReportUtil.pass(test,"Successfully validated the display of error message",getScreenshot());
//        }else{
//           ReportUtil.fail(test,"Failed to validate error message",getScreenshot());
//            //test.fail("Failed to validate error message",MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot().replace(REPORT_PATH+"\\","")).build());
//        }
        Assert.assertTrue(loginPage1.isInvalidErrorMsgDisplayed(),"Invalid Credentials message is DISPLAYED");
        //asserter.assertTrue(loginPage1.isInvalidErrorMsgDisplayed(),"Invalid Credentials message is not displayed");
        Assert.assertAll();
    }
    @Test(priority = 2,enabled = false)
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
