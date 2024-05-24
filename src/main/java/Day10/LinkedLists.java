package Day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedLists {
    public static void main(String[] args) {
        List<String> al1 = new LinkedList<>();
        al1.add("Oslo");
        al1.add("Tokyo");
        al1.add("Lisbon");
        al1.add("Rio");
        al1.add("Nairobi");
        // reading values using iterator
        Iterator<String> iter = al1.iterator();//iter is the pointer that points to the elements in the list
        while(iter.hasNext())
        {
            String city= iter.next();
            System.out.println("The City is "+city);
        }
    }
}
