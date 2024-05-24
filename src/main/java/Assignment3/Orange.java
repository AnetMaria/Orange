package Assignment3;

import org.apache.poi.util.NullLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Orange extends BaseClass{

    public Orange(String url){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    public void Login(String usrname,String pass) throws Exception {
        driver.findElement(By.name("username")).sendKeys(usrname);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//button")).submit();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']//div[1]//p"));
        if (errorMessage.isDisplayed()) {
            throw new Exception((errorMessage.getText()));
        }
    }

//    String error()throws Exception{
//        String errorMessage=driver.findElement(By.xpath("//div[@role='alert']//div[1]//p")).getText();
//        return errorMessage;
//    }
        void userPass () {
            String username = driver.findElement(By.xpath("/html/body/div//p[1]")).getText();
            System.out.println(username);
            String passwd = driver.findElement(By.xpath("/html/body/div//p[2]")).getText();
            System.out.println(passwd);
        }
        String pim () {
            driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
            String pimHeading = driver.findElement(By.xpath("//header//span//h6")).getText();
            return "The Heading of PIM page is " + pimHeading;
        }
        String leave () {
            driver.findElement(By.xpath("//div[@id='app']//ul//li[3]//span")).click();
            String leaveHeading = driver.findElement(By.xpath("//header//span//h6")).getText();
            return "The Heading of Leave page is " + leaveHeading;
        }
        String myInfo () {
            ///html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a
            driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a")).click();
            //driver.findElement(By.xpath("//div[@id='app']//li[6]//span[text()='My Info']")).click();
            String myInfoHeading = driver.findElement(By.xpath("//header//span//h6")).getText();
            return "The Heading of My Info page is " + myInfoHeading;
        }
        void logout () {
            driver.findElement(By.xpath("//div[@id='app']//header//ul//img")).click();
            driver.findElement(By.xpath("//div[@id='app']//header//ul//li[4]")).click();
        }
}
