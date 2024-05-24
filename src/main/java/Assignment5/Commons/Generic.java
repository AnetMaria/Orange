package Assignment5.Commons;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import static Assignment5.Commons.Constants.CURRENT_ENVIRONMENT;
import static Assignment5.Commons.Constants.REPORT_PATH;


public class Generic {
    public WebDriver driver;
    public static GlobalConfiguration config;
    public static ExtentReports eReports;
    public ExtentTest test;

    @BeforeSuite
    public void initSetup() throws IOException {
        config=GlobalConfiguration.getProperties();
        eReports= ReportUtility.getReport();
    }

    @BeforeMethod
    public void launchApp(){
        driver= new ChromeDriver();
        driver.get(config.get(config.get(CURRENT_ENVIRONMENT)));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        eReports.flush();
        driver.quit();
    }

    public void back(){
        driver.navigate().back();
    }

    /**
     * to take screenshot
     * @return
     * @throws IOException
     */
    public String getScreenshot() throws IOException {
        String fileName=null;
        try {
            TakesScreenshot sShot = (TakesScreenshot) driver;
            File img = sShot.getScreenshotAs(OutputType.FILE);
            fileName = REPORT_PATH+"\\Screenshotsss\\screenshots_" + getUniqueDateTimeStamp() + ".png";
            FileUtils.copyFile(img, new File(fileName));
        }catch(Exception e){
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * to get unique Date and Time Stamp
     * @return
     */
    public String getUniqueDateTimeStamp(){
        Date d = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
        String cleanedDate = simpleDate.format(d);
        return cleanedDate;
    }
}


