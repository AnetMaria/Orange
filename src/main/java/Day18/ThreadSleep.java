package Day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ThreadSleep {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.findElement(By.name("username")).sendKeys("newuser101");
        driver.findElement(By.name("password")).sendKeys("newuserpass101");

        //Implicit Wait - waits for the particular element to load
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))// in the 60 seconds duration it will check every 2 seconds
                .ignoring(NoSuchElementException.class);// instead of NoSuchElementException you can simply give Exception

        wait.until(new Function<WebDriver, WebElement>() {//anonymous function that only works in runtime
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath("//button"));
            }
        });
        WebElement button = driver.findElement(By.xpath("//button"));
        button.submit();
        driver.close();


        //driver.findElement(By.xpath("//button")).submit();
    }
}
