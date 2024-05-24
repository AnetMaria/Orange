package Assignment4.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GenericBase {
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void launchApp(String browser) throws IOException {

        switch (browser.toLowerCase()){
            case "chrome":
                  driver=getChromedriver();
                  break;
            case "edge":
                  driver=getEdgedriver();
                  break;
            case "firefox":
                  driver=getFireFoxdriver();
                  break;
        }
        //driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public WebDriver getChromedriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension",false);
        return new ChromeDriver(options);
    }
    public WebDriver getEdgedriver(){
        return new EdgeDriver();
    }
    public WebDriver getFireFoxdriver(){
       return new FirefoxDriver();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    public void back(){
        driver.navigate().back();
    }

    @AfterSuite
    public void cleanProcess() throws IOException {
        Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
    }
}
