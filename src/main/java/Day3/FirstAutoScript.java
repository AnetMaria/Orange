package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstAutoScript {
    public static void main(String[] args) throws InterruptedException {

        //launch the application on Microsoft Edge browser
        //System.setProperty("webdriver.edge.driver","C:\\Users\\WF448YD\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);


        //enter the username
        driver.findElement(By.name("username")).sendKeys("soo");
        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Anet");
        //enter password
        driver.findElement(By.name("password")).sendKeys("wrongpass");
        //click on login button
        driver.findElement(By.tagName("Button")).submit();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span"))));

    }
}
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);