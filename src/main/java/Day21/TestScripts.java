package Day21;

import org.testng.annotations.Test;

import java.util.Map;

public class TestScripts {
    @Test(dataProvider = "LoginData",dataProviderClass = Dataproviderrr.class,enabled = false)
    public void getUsernamePassword(String name,String pass){
       System.out.println(name);
        System.out.println(pass);
    }
    @Test(dataProvider = "DummyDataExcel",dataProviderClass = Dataproviderrr.class,enabled = false)
    public void getExcelData(Map<String,String>hm){
        System.out.println(hm.get("Name"));
        System.out.println(hm.get("City"));
        System.out.println(hm.get("State"));
        System.out.println(hm.get("Occupation"));
        System.out.println(hm.get("Age"));
        System.out.println(hm.get("Nationality"));
        System.out.println(hm.get("Qualification"));
    }
    @Test(dataProvider = "DummyDataHardCoded",dataProviderClass = Dataproviderrr.class)
    public void getHardCodedData(Map<String,String>hm) {
        System.out.println(hm.get("Name"));
        System.out.println(hm.get("City"));
        System.out.println(hm.get("State"));
        System.out.println(hm.get("Occupation"));
        System.out.println("\n");
    }
}
