package Assignment4;

import Assignment4.Orange;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class DriverOrange {
    public static void main(String[] args) throws IOException {
        //initializing driver using constructor
        Orange object1 = new Orange();
        object1.launchApp();
        object1.userPass();
        try {
            object1.Login("Rohit Sharma", "hitman101");
                    }
        catch (Exception e) {
            System.out.println("Login failed and the error message is " + e.getMessage());
        }
        try {
            object1.Login("Admin", "admin123");
        }
        catch(Exception e){
            System.out.println("Login Successful");
        }
            //storing headings using HashMap

            HashMap<String, String> headings = new HashMap<>();
            headings.put("pim", object1.pim());
            headings.put("leave", object1.leave());
            headings.put("myInfo", object1.myInfo());
            object1.back();
            headings.put("leave", object1.leave());
            //Iterating through the values
            Iterator<String> iter = headings.keySet().iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                String value = headings.get(key);
                System.out.println("The key is :" + key);
                System.out.println("The value is :" + value);
            }

            object1.logout();
            object1.userPass();
            object1.tearDown();
        }
    }

