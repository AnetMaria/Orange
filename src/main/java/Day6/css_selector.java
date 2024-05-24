package Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class css_selector {
    public static void main(String[] args) throws InterruptedException  {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector(" input[name='username'][placeholder='Username'")).sendKeys("incorrectlogin");//relative css
        driver.findElement(By.cssSelector(" input[name='password'],[type='password']")).sendKeys("accessdenied");//by or operator
        driver.findElement(By.cssSelector(" form[method='post']>div:nth-of-type(3)>button")).submit();
        //driver.findElement(By.partialLinkText("OrangeHRM")).click();


    }
}
