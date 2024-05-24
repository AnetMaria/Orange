package Day18;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.FileHandler;

public class Screenshots {
    public static void main(String[] args) throws IOException {

        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
        String cleanedDate = simpleDate.format(d);
        System.out.println(cleanedDate);

        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.findElement(By.name("username")).sendKeys("newuser101");
        TakesScreenshot sShot= (TakesScreenshot)driver;//typecasting
        File img = sShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(img,new File(System.getProperty("user.dir")+"\\Screenshots\\screenshots_"+cleanedDate+".png"));//


        driver.findElement(By.name("password")).sendKeys("newuserpass101");
        //second screenshot
        d = new Date();
        System.out.println(d);
        simpleDate = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
        cleanedDate = simpleDate.format(d);
       // System.out.println(cleanedDate);

        sShot= (TakesScreenshot)driver;//typecasting
        img = sShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(img,new File(System.getProperty("user.dir")+"\\Screenshots\\screenshots_"+cleanedDate+".png"));// screenshots.png is the name of the file
        //But for files we need a unique name,otherwise if we run the program multiple times we will only get the last screenshot
        WebElement button = driver.findElement(By.xpath("//button"));
        button.submit();
        driver.close();

        //In this program we are calling the Date class and related functions again and again instead we can make it a method and just call it.

        //driver.findElement(By.xpath("//button")).submit();
    }
}
