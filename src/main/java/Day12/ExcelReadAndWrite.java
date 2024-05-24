package Day12;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExcelReadAndWrite {
    public static void main(String[] args) throws IOException {
//        Open the Excel
        FileInputStream fileIS = new FileInputStream("C:\\Users\\WF448YD\\AutomationExercise1.xlsx");
//        Connect the sheet
        XSSFWorkbook wb = new XSSFWorkbook(fileIS);//contains all the worksheets in one particular Workbook
        XSSFSheet sheet1 = wb.getSheet("Sheet1");
        //for sheet2
        //XSSFSheet sheet2 = wb.getSheet("Sheet2");
//        Collect the row count
        int rowCount=sheet1.getLastRowNum();

        //Launching the application
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.bing.com/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//        Logic - Reading from Excel, applying it to app,Extracting value and writing it back to Excel
          for(int iRow=1;iRow<=rowCount;iRow++){//making for loop to iterate through the rows, iRow=1 because in Row 0 the value is Search
              //reading cell value from excel
              XSSFCell cell = sheet1.getRow(iRow).getCell(0);//getCell is pointing to that particular column in the row, if it was getCell(1) it will go for the second column
              String cellValue="";
              if(cell.getCellType()== CellType.STRING){// if the type of the data returned by the method getCellType is String then we will use the method
                  cellValue = cell.getStringCellValue();//getStringCellValue
              } else if (cell.getCellType()==CellType.NUMERIC) {
                  cellValue = String.valueOf(cell.getNumericCellValue());
              } else if (cell.getCellType()==CellType.BLANK) {
                  cellValue = "";
              }
          System.out.println(cellValue);


              driver.findElement(By.name("q")).sendKeys(cellValue);
              driver.findElement(By.id("search_icon")).submit();
              String result=driver.findElement(By.xpath("//span[@class='sb_count']")).getText();
          //writing value to a cell in Excel
              sheet1.getRow(iRow).getCell(1).setCellValue(result);
              driver.navigate().back();//to back to the next page and enter the next value in the excel sheet
          }
          driver.close();
//        Save the Excel
        FileOutputStream fileOS = new FileOutputStream("C:\\Users\\WF448YD\\AutomationExercise1.xlsx");
        wb.write(fileOS);//to write to the workbook whatever you have in your FileOutputStream
        fileIS.close();
        fileOS.close();

//        Close the Excel
    }
}
