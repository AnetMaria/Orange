package Day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class InfluenttWait {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.findElement(By.name("username")).sendKeys("newuser101");
        driver.findElement(By.name("password")).sendKeys("newuserpass101");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.submit();
        driver.close();


        //driver.findElement(By.xpath("//button")).submit();
    }
}
