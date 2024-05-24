package Assignment2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DriverOrange {
    public static void main(String[] args) {
        Orange object1 = new Orange();
        List<String> headings = new ArrayList<>();
        object1.startApp("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        object1.userPass();
        object1.Login("Rohit Sharma","hitman101");
        object1.errorMessage();
        object1.Login("Admin","admin123");
        headings.add(object1.pim());
        headings.add(object1.leave());
        headings.add(object1.myInfo());
        object1.back();
        headings.add(object1.leave());
        Iterator<String> hIterator = headings.iterator();
        while(hIterator.hasNext())
        {
            String head=hIterator.next();
            System.out.println(head);
        }
        object1.logout();
        object1.userPass();
        object1.tearDown();
    }
}
