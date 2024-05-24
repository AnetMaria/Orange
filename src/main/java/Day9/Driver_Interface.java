package Day9;

public class Driver_Interface {
    public static void main(String[] args) {
        //creating object with reference to class
        ArithmeticClass ari = new ArithmeticClass();
        System.out.println("The sum is "+ari.add(34,21));
        System.out.println("The difference is "+ari.sub(52,12));
        System.out.println("The product is "+ari.mul(21,4));

        //creating object with reference to interface
        ArithmeticInterface ari1 = new ArithmeticClass();
        System.out.println("The sum is "+ari1.add(34,21));
        System.out.println("The difference is "+ari1.sub(52,12));
        //System.out.println("The product is "+ari1.mul(21,4));// This restricts the access

        //creating object with reference to interface
        ArithmeticInterface ari2 = new ArithmeticClass2();
        System.out.println("The sum is "+ari2.add(30,21));
        System.out.println("The difference is "+ari2.sub(72,12));
        //System.out.println("The product is "+ari2.div(21,4));// This restricts the access

    }
}
