package Day11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
//maintains insertion order
public class LinkedHmap {
    public static void main(String[] args) {
        Map<String, String> lhmap = new LinkedHashMap<>();//storing country and its capital
        lhmap.put("Italy","Rome");
        lhmap.put("Germany","Berlin");
        lhmap.put("Norway","Oslo");
        lhmap.put("Netherlands","Amsterdam");
        lhmap.put("Finland","Helsinki");
        lhmap.put("France","Paris");
        lhmap.put("Sweden","Stockholm");

        //To find the capital of Bhutan
        System.out.println(lhmap.get("Bhutan"));

        //To iterate through all the values
        Iterator<String> iter = lhmap.keySet().iterator();
        while(iter.hasNext()){
            String key= iter.next();
            String value=lhmap.get(key);
            System.out.println("The Country is "+key+" and the capital is "+value);
        }
    }
}
