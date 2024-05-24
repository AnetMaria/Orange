package InheritanceDay7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
//superclass
public class Base_Inheritance {
    WebDriver driver;
    void launchApp(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    void tearDown(){
        driver.quit();
    }
}
