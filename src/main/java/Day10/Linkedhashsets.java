package Day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Linkedhashsets {
    public static void main(String[] args) {
        Set<String> hs1 = new LinkedHashSet<>();// maintain insertion order
        hs1.add("Oslo");
        hs1.add("Tokyo");
        hs1.add("Lisbon");
        hs1.add("Rio");
        hs1.add("Rio");
        hs1.add("Nairobi");
        hs1.add("Tokyo");
        Iterator<String> iter = hs1.iterator();//iter is the pointer that points to the elements in the list
        while(iter.hasNext())
        {
            String city= iter.next();
            System.out.println("The City is "+city);
        }
    }
}
