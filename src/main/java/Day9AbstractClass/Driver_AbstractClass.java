package Day9AbstractClass;

public class Driver_AbstractClass {
    public static void main(String[] args) {
        //creating object with reference to class
        ImplementAbstractClass obj = new ImplementAbstractClass();
        System.out.println("The sum is "+obj.add(34,21));
        System.out.println("The difference is "+obj.sub(52,12));
        System.out.println("The product is "+obj.mul(21,4));// This restricts the access

        //creating object with reference to abstract class
        AbstractClass obj2=new ImplementAbstractClass();
        System.out.println("The sum is "+obj2.add(30,21));
        System.out.println("The difference is "+obj2.sub(71,12));
        //System.out.println("The product is "+obj2.mul(21,4));// This method is not declared in the abstract class
    }
}
