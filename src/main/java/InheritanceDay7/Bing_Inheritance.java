package InheritanceDay7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
//subclass2
public class Bing_Inheritance extends Base_Inheritance {


    void search(String search){
        driver.findElement(By.name("q")).sendKeys(search);
        driver.findElement(By.id("search_icon")).submit();
    }
}
