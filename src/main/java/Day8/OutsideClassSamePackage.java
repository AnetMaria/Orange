package Day8;

public class OutsideClassSamePackage {
    public static void main(String[] args) {
        AccessModifiers a1 = new AccessModifiers();
        System.out.println(a1.pub);
        System.out.println(a1.pro);
        //System.out.println(a1.pri);You can't access private methods or variables outside the class in which they are defined.
        System.out.println(a1.def);
        a1.publicMethod();
        a1.protectedMethod();
        //a1.privateMethod();You can't access private methods or variables outside the class in which they are defined.
        a1.defaultMethod();

    }
}
