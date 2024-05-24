package InheritanceDay7;

public class Calc {
    public static void main(String[] args) {
        Part1calc obj1 = new Part1calc();
        System.out.println("The Sum of numbers: "+obj1.addnum(23,24));
        System.out.println("The Difference of numbers: "+obj1.subnum(23,24));
        System.out.println("The Product of numbers: "+obj1.mulnum(23,24));

        Part2calc obj2 = new Part2calc();
        System.out.println("The Sum of numbers: "+obj2.addnum(20,29));
        System.out.println("The Difference of numbers: "+obj2.subnum(33,24));
        System.out.println("The Number to the power of: "+obj2.powerofnumber(2,4));

        /*Here the classes Part1calc and Part2calc can both access the methods addnum and
        subnum , which are the methods of the Basecalc. This is because they are inheriting from
        the Basecalc class.
         */
        System.out.println("The sum is : "+obj1.sum(10,17));//method overriding
    }
}
