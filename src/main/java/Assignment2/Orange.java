package Assignment2;

import org.openqa.selenium.By;

public class Orange extends BaseClass{
    void Login(String usrname,String pass ) {
        driver.findElement(By.name("username")).sendKeys(usrname);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//button")).submit();
    }
    String errorMessage(){
        String message=driver.findElement(By.xpath("//div[@role='alert']//div[1]//p")).getText();
        return message;
    }
   void userPass(){
       String username=driver.findElement(By.xpath("/html/body/div//p[1]")).getText();
       System.out.println(username);
       String passwd=driver.findElement(By.xpath("/html/body/div//p[2]")).getText();
       System.out.println(passwd);
   }
   String pim(){
       driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
       String pimHeading=driver.findElement(By.xpath("//header//span//h6")).getText();
       return "The Heading of PIM page is "+pimHeading;
    }
    String leave(){
        driver.findElement(By.xpath("//div[@id='app']//ul//li[3]//span")).click();
        String leaveHeading=driver.findElement(By.xpath("//header//span//h6")).getText();
        return "The Heading of Leave page is "+leaveHeading;
    }
    String myInfo(){
        driver.findElement(By.xpath("//div[@id='app']//li[6]//span[text()='My Info']")).click();
        String myInfoHeading=driver.findElement(By.xpath("//header//span//h6")).getText();
        return "The Heading of My Info page is "+myInfoHeading;
    }
    void logout(){
        driver.findElement(By.xpath("//div[@id='app']//header//ul//img")).click();
        driver.findElement(By.xpath("//div[@id='app']//header//ul//li[4]")).click();
    }

}
