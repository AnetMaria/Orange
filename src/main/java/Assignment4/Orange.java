package Assignment4;


import Assignment4.Common.GenericBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Orange extends BaseClass {

    public void launchApp() throws IOException {
        PropertiesFile property=new PropertiesFile();
        String url=property.getUrl();
        String browser=property.getBrowser();
        if("chrome".equals(browser)){
            BaseClass.driver=new ChromeDriver();
        }else if("edge".equals(browser)){
            BaseClass.driver=new EdgeDriver();
        }else {
            throw new IllegalArgumentException("Unsupported Browser : "+browser);
        }

        BaseClass.driver.get(url);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    public void Login(String usrname,String pass) throws Exception {
        driver.findElement(By.name("username")).sendKeys(usrname);
        driver.findElement(By.name("password")).sendKeys(pass);
        ValidationScreenshots.getScreenshot();
        driver.findElement(By.xpath("//button")).submit();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']//div[1]//p"));
        if (errorMessage.isDisplayed()) {
            throw new Exception((errorMessage.getText()));
        }
    }
        public void userPass () {
            String username = driver.findElement(By.xpath("//div[@id='app']//p")).getText();
            System.out.println(username);
            String passwd = driver.findElement(By.xpath("//div[@id='app']//p[2]")).getText();
            System.out.println(passwd);
        }
        public String pim () throws IOException {
            driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
            String pimHeading = driver.findElement(By.xpath("//header//span//h6")).getText();
            ValidationScreenshots.getScreenshot();
            return "The Heading of PIM page is " + pimHeading;
        }
        String leave () throws IOException {
            driver.findElement(By.xpath("//div[@id='app']//ul//li[3]//span")).click();
            String leaveHeading = driver.findElement(By.xpath("//header//span//h6")).getText();
            ValidationScreenshots.getScreenshot();
            return "The Heading of Leave page is " + leaveHeading;
        }
        String myInfo () throws IOException {
            driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a")).click();
            String myInfoHeading = driver.findElement(By.xpath("//header//span//h6")).getText();
            ValidationScreenshots.getScreenshot();
            return "The Heading of My Info page is " + myInfoHeading;
        }
        void logout () {
            driver.findElement(By.xpath("//div[@id='app']//header//ul//img")).click();
            driver.findElement(By.xpath("//div[@id='app']//header//ul//li[4]")).click();
        }
}
