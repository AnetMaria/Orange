package Assignment6.Common;

import Assignment6.Common.GlobalConfiguration;
import Assignment6.Common.ReportUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Assignment6.Common.Constants.CURRENT_ENVIRONMENT;
import static Assignment6.Common.Constants.REPORT_PATH;


public class Generic {
    public WebDriver driver;
    public static GlobalConfiguration config;
    public static ExtentReports eReports;
    public ExtentTest test;
    public Asserter asserter;

    @BeforeSuite
    public void initSetup() throws IOException {
        config=GlobalConfiguration.getProperties();
        eReports= ReportUtility.getReport();
    }

    @Parameters("browser")
    @BeforeMethod
    public void launchApp(String browser){

        switch (browser.toLowerCase()){
            case "chrome":
                driver=getChromedriver();
                break;
            case "edge":
                driver=getEdgedriver();
                break;
            default:
                System.out.println("Browser not found");
        }
        driver.get(config.get(config.get(CURRENT_ENVIRONMENT)));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getChromedriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension",false);
        return new ChromeDriver(options);
    }
    public WebDriver getEdgedriver(){
        return new EdgeDriver();
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

    @AfterSuite
    public void cleanProcess() throws IOException {
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
        Runtime.getRuntime().exec("TaskKill /im msedge.exe /f");
    }
}


