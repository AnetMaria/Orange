package Day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {

//        Properties prop = new Properties();
//        System.out.println(System.getProperty("user.dir"));//gets the directory of the folder
//        //FileInputStream fis = new FileInputStream("C:\\Users\\WF448YD\\IdeaProjects\\SeleniumJava\\src\\main\\resources\\src\\main\\resources\\configure.properties");
//        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\configure.properties");
//        prop.load(fis);
//
//        //String url=prop.getProperty("QA");//This QA is the key which will fetch the URL associated with it. If you want another URL, like DEV you just have to change the key
//        //String url=prop.getProperty("DEV");//But if you dont want to make changes in the script and rather make changes in the config file
//        String url=prop.getProperty(prop.getProperty("env"));// env has PROD and PROD has a URL which will be fetched with this code
//        System.out.println(url);

        //calling the config file using method
        WebDriver driver=new ChromeDriver();
        driver.get(PropertiesFile.getConfigValue(PropertiesFile.getConfigValue("env")));
        Thread.sleep(3000);

//        //enter the username
//        driver.findElement(By.name("username")).sendKeys("soo");
//        //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Anet");
//        //enter password
//        driver.findElement(By.name("password")).sendKeys("wrongpass");
//        //click on login button
//        driver.findElement(By.tagName("Button")).submit();
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span"))));

    }
}
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);