package Day11;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
//sorted order
public class TreeMapss {
    public static void main(String[] args) {
        Map<String, String> tmap = new TreeMap<>();//storing country and its capital
        tmap.put("Italy","Rome");
        tmap.put("Germany","Berlin");
        tmap.put("Norway","Oslo");
        tmap.put("Netherlands","Amsterdam");
        tmap.put("Finland","Helsinki");
        tmap.put("France","Paris");
        tmap.put("Sweden","Stockholm");

        //To find the capital of Bhutan
        System.out.println(tmap.get("Bhutan"));

        //To iterate through all the values
        Iterator<String> iter = tmap.keySet().iterator();
        while(iter.hasNext()){
            String key= iter.next();
            String value=tmap.get(key);
            System.out.println("The Country is "+key+" and the capital is "+value);
        }
    }
}
