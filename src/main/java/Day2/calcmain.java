package Day2;

public class calcmain {
    public static void main(String[] args) {
        calculation obj1=new calculation();
        int summation= obj1.sum(10,24);
        System.out.println("Sum of the numbers is: "+summation);
        int subtract= obj1.sub(5,24);
        System.out.println("Difference of the numbers is: "+subtract);
        int multiply= obj1.mul(10,8);
        System.out.println("Multiplication of the numbers is: "+multiply);
        int division= obj1.div(100,24);
        System.out.println("Division of the numbers is: "+division);
    }
}
