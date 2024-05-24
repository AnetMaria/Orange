package Day13;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelRW {
    XSSFWorkbook wb;
    FileInputStream fileIS;
    //initialize excel
//    public void initExcel(String xlPath) throws IOException {
//        //open the Excel
//        fileIS = new FileInputStream(xlPath);
//        //connect the sheet
//        wb = new XSSFWorkbook(fileIS);//contains all the worksheets in one particular Workbook
//    }
//    The below code makes use of constructor
    public ExcelRW(String xlPath) throws IOException {
        fileIS = new FileInputStream(xlPath);
        wb = new XSSFWorkbook(fileIS);
    }

    //create sheet object to be used everywhere instead of repeating the same line
    public XSSFSheet getSheet(String sheetName){
        XSSFSheet sheet1 = wb.getSheet(sheetName);
        return sheet1;
    }
    //row count
    public int getRowCount(String sheetName){
//        XSSFSheet sheet1 = wb.getSheet(sheetName);
//        return sheet1.getLastRowNum();INSTEAD OF USING THIS WE CAN USE ONE LINE OF CODE
          return getSheet(sheetName).getLastRowNum();
    }
    //column count
    public int getColumnCount(String sheetName){
        return getSheet(sheetName).getRow(0).getLastCellNum();
    }
    //read operation
    public String readCellValue(String sheetName,int row,int column){
        XSSFCell cell = getSheet(sheetName).getRow(row).getCell(column);//getCell is pointing to that particular column in the row, if it was getCell(1) it will go for the second column
        String cellValue="";
        if(cell.getCellType()== CellType.STRING){// if the type of the data returned by the method getCellType is String then we will use the method
            cellValue = cell.getStringCellValue();//getStringCellValue
        } else if (cell.getCellType()==CellType.NUMERIC) {
            cellValue = String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType()==CellType.BLANK) {
            cellValue = "";
        }
        return cellValue;
    }
    //write operation
    public void writeCellValue(String sheetName,int row,int column,String value){
        Cell c = null;
        try {
         c   = getSheet(sheetName).getRow(row).getCell(column);
       }
       catch (Exception e)
       {
           System.out.println( "Exception ->"+e.getMessage() );
       }
       c.setCellValue(value);
    }
    //save operation
    public void saveAndCloseWorkbook(String xlPath) throws IOException {
        FileOutputStream fileOS = new FileOutputStream(xlPath);
        wb.write(fileOS);//to write to the workbook whatever you have in your FileOutputStream
        fileIS.close();
        fileOS.close();
    }

}
/*this is the code that works
    public void writeCellValue(String sheetName,int row,int column,String value) throws NullPointerException{

      Cell c1= getSheet(sheetName).createRow(row).createCell(column);
      c1.setCellValue(value);
    }*/

/*       Cell c = null;
       try {
            c   = getSheet(sheetName).getRow(row).getCell(column);
        }
        catch (Exception e)
        {
            System.out.println( "Exception ->"+e.getMessage() );
            c= getSheet(sheetName).getRow(row).createCell(column);
        }
        c.setCellValue(value);*/