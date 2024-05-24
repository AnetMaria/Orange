package Day8_AccessModifiers;

import Day8.AccessModifiers;

public class OutsidePackage {
    public static void main(String[] args) {
        AccessModifiers a1 = new AccessModifiers();
        System.out.println(a1.pub);
        //System.out.println(a1.pro); only works with inheritance-outside package
        //System.out.println(a1.pri);only works in same class
        //System.out.println(a1.def);only works in same package
        a1.publicMethod();
        //a1.protectedMethod();only works with inheritance-outside package
        //a1.privateMethod();only works in same class
        //a1.defaultMethod();only works in same package

    }
}
