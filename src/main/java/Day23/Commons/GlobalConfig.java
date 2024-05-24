package Day23.Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
This class is responsible for providing properties from Property file.
 */
public class GlobalConfig {
    private static GlobalConfig config=null;         //no object has been created for this class
    private Properties prop;
    private FileInputStream fis;

    /**
     * Add a private constructor
     * So that outside world cannot create an object
     * Singleton class
     */

    private GlobalConfig() throws IOException {
        try {
            prop = new Properties();
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            prop.load(fis);
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Returns a singleton object - singleton class only returns one object
     * If there is no object of the class, then it will create an object of the class
     */
    public static GlobalConfig getProperties() throws IOException { // GlobalConfig is accessed using getProperties class
        if(config==null){
            config=new GlobalConfig();
        }
        return config;
    }

    /**
     * Get the property value
     * @param key
     * @return
     */
    public String get(String key){
        return prop.getProperty(key);
    }

    /**
     * Set a property value to the file in the memory, not the physical one
     * @param key
     * @param value
     */
    public void set(String key,String value){
        prop.setProperty(key,value);
    }
}
