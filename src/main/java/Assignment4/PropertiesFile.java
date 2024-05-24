package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;

public class PropertiesFile {
    private Properties prop;
    public PropertiesFile() throws IOException {
        prop=new Properties();
        try{
            FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\configure.properties");
            prop.load(fis);
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getUrl(){
        return prop.getProperty("url");
    }
    public String getBrowser(){
        return prop.getProperty("browser");
    }
}
