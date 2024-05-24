package Assignment3;

import Day13.ExcelRW;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class useGenericExcel {
    public static void main(String[] args) throws IOException {
        GenericExcel excel = new GenericExcel("C:\\Users\\WF448YD\\Orange.xlsx");
        String sheetName="Orangehrm";
        int rowCount=excel.getRowCount(sheetName);
        System.out.println("Total number of rows in the sheet "+rowCount);
//launch browser
        WebDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //for(int iRow=1;iRow<= rowCount;iRow++) {
            String cellValue = excel.readCellValue(sheetName,1, 0);
            driver.findElement(By.name("username")).sendKeys(cellValue);
            String cellValue1=excel.readCellValue(sheetName,1,1);
            driver.findElement(By.name("password")).sendKeys(cellValue1);
            driver.findElement(By.xpath("//button")).submit();
            String errorMsg=driver.findElement(By.xpath("//div[@role='alert']//div[1]//p")).getText();
            excel.writeCellValue("Orangehrm",1,2,errorMsg);

            String cellValue2 = excel.readCellValue(sheetName,2, 0);
            driver.findElement(By.name("username")).sendKeys(cellValue2);
            String cellValue3 = excel.readCellValue(sheetName,2, 1);
            driver.findElement(By.name("password")).sendKeys(cellValue3);
            driver.findElement(By.xpath("//button")).submit();
            excel.saveAndCloseWorkbook("C:\\Users\\WF448YD\\Orange.xlsx");
            driver.close();
    }
}
