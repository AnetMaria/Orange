package Day25;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstAutoScript {
    public static void main(String[] args) throws InterruptedException, IOException {

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\Report.html");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        ExtentTest test=extentReports.createTest("Orange");
        test.info("Execution started");

        test.assignAuthor("Anet");//name of the person who wrote the script
        test.assignDevice("Laptop");//mobile device,desktop,Android,Apple etc
        //assign category based on type of testing, type of functionality etc;
        test.assignCategory("Login");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        test.pass("Successfully launched application");

        //enter the username
        driver.findElement(By.name("username")).sendKeys("soo");
        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Anet");
        //enter password
        driver.findElement(By.name("password")).sendKeys("wrongpass");
        //click on login button
        driver.findElement(By.tagName("Button")).submit();
        test.pass("Invalid login");

        TakesScreenshot sShot= (TakesScreenshot)driver;
        File img = sShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(img,new File(System.getProperty("user.dir")+"\\Reports\\Screenshotsss\\screenshots.png"));//
        test.fail("ooops", MediaEntityBuilder.createScreenCaptureFromPath("Screenshotsss\\screenshots.png").build());

        extentReports.flush();
        driver.quit();
    }
}
