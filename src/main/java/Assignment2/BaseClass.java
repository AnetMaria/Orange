package Assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected WebDriver driver;
    public void startApp(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    public void tearDown(){
        driver.quit();
    }
    public void back(){
        driver.navigate().back();
    }
}
