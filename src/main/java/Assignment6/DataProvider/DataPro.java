package Assignment6.DataProvider;

import Day13.ExcelRW;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataPro {
    @DataProvider(name="InvalidLoginData")
    public static Object[][]dataProvider(){

        return new Object[][]{

                {"Anet Maria","BooksAreSanctuary"},
                {"Baladevika Gopi","CrazyCatLady13"},
                {"Sachin Rampur","FriendOfJesus25"}
        };
    }
    @DataProvider(name="DataExcel")
    public static Iterator<Object[]> dataProviderExcel() throws IOException {
        String sheetName="Sheet2";
        ExcelRW excelRW = new ExcelRW(System.getProperty("user.dir") + "\\src\\main\\resources\\DataProvider.xlsx");
        int rowCount = excelRW.getRowCount(sheetName);
        int columnCount = excelRW.getColumnCount(sheetName);
        //Create index in a list
        ArrayList<Object[]> list = new ArrayList<>();
        for(int iRow=1;iRow<=rowCount;iRow++){
            Object[] obj = new Object[1];
            Map<String, String> map = new HashMap<>();

            for(int iCol=0;iCol<columnCount;iCol++){
                String key = excelRW.readCellValue(sheetName, 0, iCol);
                String value=excelRW.readCellValue(sheetName,iRow,iCol);
                map.put(key,value);
            }
            obj[0]=map;//adding map to the object
            list.add(obj);//adding object to list
        }
        return list.iterator();
    }

}
