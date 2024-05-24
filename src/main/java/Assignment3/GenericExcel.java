package Assignment3;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenericExcel {
    XSSFWorkbook wb;
    FileInputStream fileIS;
    public GenericExcel(String xlPath) throws IOException {
        fileIS = new FileInputStream(xlPath);
        wb = new XSSFWorkbook(fileIS);
    }

        public XSSFSheet getSheet(String sheetName){
        XSSFSheet sheet1 = wb.getSheet(sheetName);
        return sheet1;
    }

    public int getRowCount(String sheetName){
        return getSheet(sheetName).getLastRowNum();
    }

    public String readCellValue(String sheetName,int row,int column){
        XSSFCell cell = getSheet(sheetName).getRow(row).getCell(column);
        String cellValue="";
        if(cell.getCellType()== CellType.STRING){
            cellValue = cell.getStringCellValue();
        } else if (cell.getCellType()==CellType.NUMERIC) {
            cellValue = String.valueOf(cell.getNumericCellValue());
        } else if (cell.getCellType()==CellType.BLANK) {
            cellValue = "";
        }
        System.out.println(cellValue);
        return cellValue;
    }


       public void writeCellValue(String sheetName,int row,int column,String result) {
           Cell c=getSheet(sheetName).getRow(row).getCell(column);
           c.setCellValue(result);
       }
        public void saveAndCloseWorkbook(String xlPath) throws IOException {
        FileOutputStream fileOS = new FileOutputStream(xlPath);
        wb.write(fileOS);
        fileIS.close();
        fileOS.close();
    }
}
