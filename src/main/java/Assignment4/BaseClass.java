package Assignment4;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    static WebDriver driver;
    public void tearDown(){
        driver.quit();
    }
    public void back(){
        driver.navigate().back();
    }

}
