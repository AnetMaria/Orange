package Day11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapp {
    public static void main(String[] args) {
        Map<String, String> hmap = new HashMap<>();//storing country and its capital
        hmap.put("Sri Lanka","Colombo");
        hmap.put("India","New Delhi");
        hmap.put("Pakistan","Islamabad");
        hmap.put("Afghanistan","Kabul");
        hmap.put("Bhutan","Thimphu");
        hmap.put("Nepal","Kathmandu");
        hmap.put("Bangladesh","Dhaka");

        //To find the capital of Bhutan
        System.out.println(hmap.get("Bhutan"));

        //To iterate through all the values
        Iterator<String> iter = hmap.keySet().iterator();
        while(iter.hasNext()){
            String key= iter.next();
            String value=hmap.get(key);
            System.out.println("The Country is "+key+" and the capital is "+value);
        }
    }
}
