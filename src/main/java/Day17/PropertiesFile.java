package Day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    public static String getConfigValue(String key) throws IOException {//when you pass the key as argument you will get the value
        Properties prop = new Properties();// every time this method is called it is creating a new object
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\configure.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}
//another way in which there is only object created of the class Property
// public static Properties prop;
//public static String getConfigValue(String key) throws IOException {//when you pass the key as argument you will get the value
//        if(prop==null){
//        prop = new Properties();// every time this method is called it is creating a new object
//        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\configure.properties");
//        prop.load(fis);
//        fis.close;
//        }
//        return prop.getProperty(key);
//    }