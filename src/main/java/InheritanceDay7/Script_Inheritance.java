package InheritanceDay7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
//subclass1
public class Script_Inheritance extends Base_Inheritance{
        //Enter and Extract Values
     String enterExtract(String usrname,String pass ){
         driver.findElement(By.name("username")).sendKeys(usrname);
         driver.findElement(By.name("password")).sendKeys(pass);
         driver.findElement(By.xpath("//form[@method='post']//Button")).submit();
         String error_msg=driver.findElement(By.xpath("//div[@role='alert']//div[1]//p")).getText();
         return error_msg;
     }
}
