package Day28;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;




import java.util.concurrent.TimeUnit;

public class FirstAutoScript {
    private static Logger log = LogManager.getLogger(FirstAutoScript.class);

    public static void main(String[] args) throws InterruptedException {
        log.info("Started Execution");
         //soft assert

        SoftAssert Assert = new SoftAssert();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.error("Dracarys!!");

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
        Assert.assertAll();
        driver.quit();
        log.warn("Taking too long");
        System.exit(0);
    }
}
