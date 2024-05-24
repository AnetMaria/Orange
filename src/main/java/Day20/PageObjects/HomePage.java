package Day20.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    //collecting the elements of the page that we want to use
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement lk_signIn;
    //this above is the same as
    //WebElement lk_signIn=driver.findElement(By.xpath("//a[@href='/login']"));

    public void clickSignInButton(){
        lk_signIn.click();
    }
}
