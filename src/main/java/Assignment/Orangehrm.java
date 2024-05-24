package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Orangehrm {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        //find Username and Password for the site and print it to console
        String username=driver.findElement(By.xpath("//p[1]")).getText();
        System.out.println(username);
        String passwd=driver.findElement(By.xpath("//p[2]")).getText();
        System.out.println(passwd);
        //try to login with wrong username and password
        driver.findElement(By.name("username")).sendKeys("newuser101");
        driver.findElement(By.name("password")).sendKeys("newuserpass101");
        driver.findElement(By.xpath("//button")).submit();
//        using cssSelector
//        driver.findElement(By.cssSelector(" input[name='username'][placeholder='Username'")).sendKeys("incorrectlogin");//relative css
//        driver.findElement(By.cssSelector(" input[name='password'],[type='password']")).sendKeys("accessdenied");//by or operator
//        driver.findElement(By.cssSelector(" form[method='post']>div:nth-of-type(3)>button")).submit();
        //capture error message and print it to console
        String error_msg=driver.findElement(By.xpath("//div[@role='alert']//div[1]//p")).getText();
        System.out.println("The error message displayed is "+error_msg);
        //input valid name and password
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        //login to application
        driver.findElement(By.xpath("//button")).submit();
        //wait for dashboard to load
        //click on PIM using absolute xpath
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
        //print the heading of the page PIM
        String pimHeading=driver.findElement(By.xpath("//header//span//h6")).getText();
        System.out.println("The heading of the page when you click on PIM from the dashboard is "+pimHeading);
        //click on leave
        driver.findElement(By.xpath("//div[@id='app']//ul//li[3]//span")).click();
        //print the heading of leave
        String leaveHeading=driver.findElement(By.xpath("//header//span//h6")).getText();
        System.out.println("The heading of the page when you click on Leave from the dashboard is "+leaveHeading);
        //click on "MY Info" using text locator
        driver.findElement(By.xpath("//div[@id='app']//li[6]//span[text()='My Info']")).click();
        //print the heading
        String myInfoHeading=driver.findElement(By.xpath("//header//span//h6")).getText();
        System.out.println("The heading of the page when you click on 'My Info' from the dashboard is "+myInfoHeading);
        //use back button of browser to navigate back to leave page
        driver.navigate().back();
        String leaveHeading2=driver.findElement(By.xpath("//header//span//h6")).getText();
        System.out.println("The heading of the page when you click on back button of browser is "+leaveHeading2);
        //click on username from top-right corner
        driver.findElement(By.xpath("//div[@id='app']//header//ul//img")).click();
        //click on logout
        //driver.findElement(By.linkText("Logout")).click();

        driver.findElement(By.xpath("//div[@id='app']//header//ul//li[4]")).click();

        //By cssSelector
        //driver.findElement(By.cssSelector("  div[id='app'] header ul li:nth-of-type(4)")).click();
        String username1=driver.findElement(By.xpath("//p[1]")).getText();
        System.out.println("The Username displayed on the page is "+username1);
        String passwd1=driver.findElement(By.xpath("//p[2]")).getText();
        System.out.println("The Username displayed on the page is "+passwd1);

    }
}
