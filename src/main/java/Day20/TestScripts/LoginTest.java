package Day20.TestScripts;

import Day20.Commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    @Test
    public void validInvalidLogin(){
        launchApp();
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        driver.findElement(By.name("email")).sendKeys("Breaking Bad");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Saymyname!!1");
        driver.findElement(By.xpath("//form[@action='/login']//button[1]")).submit();

        if(driver.findElement(By.xpath("//form[@action='/login']//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed()){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        tearDown();
    }
}
