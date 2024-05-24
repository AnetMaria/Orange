package Day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicWait {
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.findElement(By.name("username")).sendKeys("newuser101");
        driver.findElement(By.name("password")).sendKeys("newuserpass101");

        //Explicit Wait - waits for the particular element to load
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button"))));
        WebElement button = driver.findElement(By.xpath("//button"));
        button.submit();
        driver.close();


        //driver.findElement(By.xpath("//button")).submit();
    }
}
