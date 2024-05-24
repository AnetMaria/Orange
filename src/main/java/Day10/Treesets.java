package Day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Treesets {
    public static void main(String[] args) {
        Set<String> hs1 = new TreeSet<>();// does not maintain insertion order, for that we should use LinkedHashSet
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
        //To find whether an element is there in set
        System.out.println(hs1.contains("Rio"));
        //To add element in between
    }
}
