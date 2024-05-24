package Day12;

import Day12.Day12_Exercise;

import java.util.*;

public class Driver_Exercise {
    public static void main(String[] args) {

        //using constructor
        Day12_Exercise custInfo1 = new Day12_Exercise("Ishaan Kishan","Mumbai","Maharashtra","Verna",new ArrayList<String>(Arrays.asList("8156862690","8714236500")));//one object for one customer
//second object
        Day12_Exercise custInfo2 = new Day12_Exercise("Virat Kohli","Bangalore","Karnataka","i20",new ArrayList<String >(Arrays.asList("5683929831","9011212122","8901235566")));//one object for one customer
//        updating values
        custInfo2.setCity("Delhi");
//third object
        Day12_Exercise custInfo3 = new Day12_Exercise("Sanju Samson","Jaipur","Rajasthan","Creta",new ArrayList<String>(Arrays.asList("767687236472","4375837458")));//one object for one customer
        //We should get the city of a person by entering his name.
        //We will use maps where key will be the name and value will be object
        //because object has all the info
        HashMap<String, Day12_Exercise> customerMap = new HashMap<>();
        customerMap.put("Ishaan Kishan",custInfo1);
        customerMap.put("Virat Kohli",custInfo2);
        customerMap.put("Sanju Samson",custInfo3);

        //Retrieving value
        System.out.println(customerMap.get("Virat Kohli").getCarModel());
        System.out.println(customerMap.get("Virat Kohli").getState());
        System.out.println(customerMap.get("Ishaan Kishan").getCarModel());
        System.out.println(customerMap.get("Sanju Samson").getPhoneNumbers());

        //using Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Customer name: ");
        String customer=sc.nextLine();
        System.out.println(customerMap.get(customer).getCarModel());
        System.out.println(customerMap.get(customer).getCity());
        System.out.println(customerMap.get(customer).getState());
    }
}
