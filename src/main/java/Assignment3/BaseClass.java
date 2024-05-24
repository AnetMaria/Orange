package Assignment3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
     public static WebDriver driver;
    public void tearDown(){
        driver.quit();
    }
    public void back(){
        driver.navigate().back();
    }

}
