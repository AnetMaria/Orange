package Day23.Commons.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.EventObject;

public class PageObjectBase {

    public static final int DEFAULT_TIMEOUT=5;
    WebDriver driver;
    public PageObjectBase(WebDriver driver){
        this.driver=driver;
    }

    public void click(WebElement element){//// Click using Default wait
        //initWait().until(ExpectedConditions.elementToBeClickable(element)).click();
        //element.click();
        click(element,DEFAULT_TIMEOUT);// Calling click with default timeout inside click() with custom timeout
    }
    public void typeText(WebElement element,String text){
        initWait().until(ExpectedConditions.elementToBeClickable(element)).clear();//first it checks whether element is clickable then it clears the value
        element.sendKeys(text);
    }
    public boolean isElementDisplayed(WebElement element){
        try {
             initWait().until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
        }catch (Exception e){
            return false;
        }
        return true;
        //return element.isDisplayed();
    }
    public void click(WebElement element,int timeout){// Click using Custom wait
        customWait(timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public WebDriverWait initWait(){
       return new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_TIMEOUT));
        //return initWait(DEFAULT_TIMEOUT);
    }
    public WebDriverWait customWait(int timeOut){
        return new WebDriverWait(driver,Duration.ofSeconds(timeOut));
    }
}
