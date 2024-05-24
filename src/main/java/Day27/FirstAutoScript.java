package Day27;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FirstAutoScript {
    public static void main(String[] args) throws InterruptedException {
        
        //soft assert
        SoftAssert Assert = new SoftAssert();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if(driver.getTitle().equals("OrangeHRM"))
        {
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        //The above validation can be done in one line using assert
        //Hard Assert
        Assert.assertEquals(driver.getTitle(),"OrangHRM","The title is not matching");
        // Here the expected title is OrangeHRM  and if it is not the one that is displayed, then the error message will be displayed.


        //enter username
        driver.findElement(By.name("username")).sendKeys("soo");
        //enter password
        driver.findElement(By.name("password")).sendKeys("wrongpass");
        //click on login button
        driver.findElement(By.tagName("Button")).submit();
        driver.quit();
        Assert.assertAll();
        System.exit(0);
    }
}
