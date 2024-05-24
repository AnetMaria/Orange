package InheritanceDay7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Bing {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.bing.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.name("q")).sendKeys("Weather");
        driver.findElement(By.id("search_icon")).submit();
    }
}
