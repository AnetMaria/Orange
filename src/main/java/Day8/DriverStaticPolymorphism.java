package Day8;

public class DriverStaticPolymorphism {
    public static void main(String[] args) {
        StaticPolymorphism obj1 = new StaticPolymorphism();
        System.out.println("The sum of two integers :"+obj1.sum(20,30));
        System.out.println("The sum of three integers :"+obj1.sum(20,30,13));
        System.out.println("The sum of two doubles :"+obj1.sum(25.7,-11.8));
    }
}
