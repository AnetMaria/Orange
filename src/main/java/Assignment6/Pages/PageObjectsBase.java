package Assignment6.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjectsBase {
    public static final int DEFAULT_TIMEOUT=5;
    WebDriver driver;
    public PageObjectsBase(WebDriver driver){
        this.driver=driver;
    }

    /**
     * Common action method for clicking on an element
     * Calls the another click method that makes use of customized wait
     * @param element
     */
    public void click(WebElement element) {
        click(element, DEFAULT_TIMEOUT);
    }

    /**
     * Common action method for entering username and password
     * @param element
     * @param text
     */
    public void typeText(WebElement element,String text){
        initWait().until(ExpectedConditions.elementToBeClickable(element)).clear();
        element.sendKeys(text);
    }

    /**
     * Common action method- To check whether an element is displayed
     * @param element
     * @return true or false
     */
    public boolean isElementDisplayed(WebElement element){
        try {
            initWait().until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * Clicking on an element using customized wait
     * @param element
     * @param timeout
     */
    public void click(WebElement element,int timeout){
        customWait(timeout).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Method for declaring a default timeout
     * Time is given as constant variable
     * @return
     */
    public WebDriverWait initWait(){
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        //return initWait(DEFAULT_TIMEOUT);
    }

    /**
     * custom wait where you can specify the amount of time driver should wait
     * @param timeOut
     * @return
     */
    public WebDriverWait customWait(int timeOut){
        return new WebDriverWait(driver,Duration.ofSeconds(timeOut));
    }
}
