package Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerDetails {
    public static void main(String[] args) {
        ExerciseHyundai custInfo1 = new ExerciseHyundai();//one object for one customer
        custInfo1.setName("Ishaan Kishan");
        custInfo1.setCity("Mumbai");
        custInfo1.setState("Maharashtra");
        custInfo1.setCarModel("Verna");
        ArrayList<String> phoneNumber = new ArrayList<>();
        phoneNumber.add("8156862690");
        phoneNumber.add("8714236500");
        custInfo1.setPhoneNumbers(phoneNumber);
//second object
        ExerciseHyundai custInfo2 = new ExerciseHyundai();//one object for one customer
        custInfo2.setName("Virat Kohli");
        custInfo2.setCity("Banglore");
        custInfo2.setState("Karnataka");
        custInfo2.setCarModel("i20");
        //how to do the steps in previous object in a single line
        custInfo2.setPhoneNumbers(new ArrayList<String >(Arrays.asList("5683929831","9011212122","8901235566")));
//third object
        ExerciseHyundai custInfo3 = new ExerciseHyundai();//one object for one customer
        custInfo3.setName("Sanju Samson");
        custInfo3.setCity("Jaipur");
        custInfo3.setState("Rajasthan");
        custInfo3.setCarModel("Creta");
        custInfo3.setPhoneNumbers(new ArrayList<String>(Arrays.asList("767687236472","4375837458")));
        //We should get the city of a person by entering his name.
        //We will use maps where key will be the name and value will be object
        //because obje;ct has all the info
        HashMap<String, ExerciseHyundai> customerMap = new HashMap<>();
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
        System.out.println(customerMap.get(customer).getState());
    }
}
