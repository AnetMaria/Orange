package Day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) {
        List<String> al1 = new ArrayList<>();
        al1.add("Oslo");
        al1.add("Tokyo");
        al1.add("Lisbon");
        al1.add("Rio");
        al1.add("Nairobi");
        al1.add("Rio");
        al1.add("Tokyo");
        al1.add(3,"Moscow");
        // reading values using iterator
        Iterator<String> iter = al1.iterator();//iter is the pointer that points to the elements in the list
        while(iter.hasNext())
        {
            String city= iter.next();
            System.out.println("The City is "+city);
        }
        //To read value from first index
        System.out.println("The first city in the list is "+al1.get(0));
        //without generic
//        List al2 = new ArrayList();
//        al2.add(23);
//        al2.add("Name: Anna");



    }
}
