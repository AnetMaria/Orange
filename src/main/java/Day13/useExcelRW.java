package Day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class useExcelRW {
    public static void main(String[] args) throws IOException {
//        ExcelRW excelRW = new ExcelRW();
//        excelRW.initExcel("C:\\Users\\WF448YD\\AutomationExercise1.xlsx");
        //either we can do this or we can pass it as parameters of constructors because those lines of code will be executed anyway in the beginning
        ExcelRW excelRW = new ExcelRW("C:\\Users\\WF448YD\\AutomationExercise1.xlsx");
        String sheetName="Sheet1";
        //excelRW.getSheet(sheetName);
        int rowCount=excelRW.getRowCount(sheetName);
//launch browser
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.bing.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        for(int iRow=1;iRow<= rowCount;iRow++){
            String cellValue=excelRW.readCellValue(sheetName,iRow,0);
            driver.findElement(By.name("q")).sendKeys(cellValue);
            driver.findElement(By.id("search_icon")).submit();
            String result=driver.findElement(By.xpath("//span[@class='sb_count']")).getText();
            //writing to cell
            excelRW.writeCellValue(sheetName,iRow,1,result);
            driver.navigate().back();
        }
        excelRW.saveAndCloseWorkbook("C:\\Users\\WF448YD\\AutomationExercise1.xlsx");
        driver.close();
    }
}
