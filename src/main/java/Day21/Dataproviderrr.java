package Day21;

import Day13.ExcelRW;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.*;

public class Dataproviderrr {

    @DataProvider(name="LoginData")
    public static Object[][]dataProvider(){

        return new Object[][]{

                {"Anet","lazyGal202"},
                {"Bala","CrazyCatLady13"},
                {"Sachin","FriendOfJesus25"}
        };
    }
    @DataProvider(name="DummyDataExcel")
    public static Iterator<Object[]>dataProviderExcel() throws IOException {
//Read values from each row of Excel
        String sheetName="Sheet1";
        ExcelRW excelRW = new ExcelRW(System.getProperty("user.dir") + "\\src\\main\\resources\\DataProvider.xlsx");//Creating an object of ExcelRW class from Day13
        int rowCount = excelRW.getRowCount(sheetName);
        int columnCount = excelRW.getColumnCount(sheetName);
        
        //Create index in a list
        ArrayList<Object[]> list = new ArrayList<>();
        
        for(int iRow=1;iRow<=rowCount;iRow++){
            
            //for each row we need an object array( in our case we have 3 rows therefore 3 object arrays)
            Object[] obj = new Object[1];// only one map for each array in a row
            // create a Map
            Map<String, String> map = new HashMap<>();

            for(int iCol=0;iCol<columnCount;iCol++){

                String key = excelRW.readCellValue(sheetName, 0, iCol);
                String value=excelRW.readCellValue(sheetName,iRow,iCol);
                //add all the data as key and value in the map
                map.put(key,value);
            }
            obj[0]=map;//adding map to the object
            list.add(obj);//adding object to list
        }
        return list.iterator();
    }

    //without using excel
    @DataProvider(name="DummyDataHardCoded")
    public static Iterator<Object[]>dataProviderHardCoded(){

        return Arrays.asList(new Object[]{
           new HashMap<String,String>(){{
               put("Name","Baladevika");
               put("City","Jaipur");
               put("State","Rajasthan");
               put("Occupation","Puppet Dancer");
           }}},new Object[]{
                new HashMap<String,String>(){
                    {
                        put("Name", "Ann Santa");
                                put("City", "Mumbai");
                                put("State", "Maharashtra");
                                put("Occupation", "Don");
                    }}}
        ).iterator();
    }
}
