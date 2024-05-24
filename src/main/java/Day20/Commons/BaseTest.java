package Day20.Commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    public void launchApp(){
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    public void tearDown(){
        driver.quit();
    }
    public void back(){
        driver.navigate().back();
    }
}
