package Day8_AccessModifiers;

import Day8.AccessModifiers;

public class OutsidePackageExtendsClass extends AccessModifiers {
        public static void main(String[] args) {
            OutsidePackageExtendsClass a2 = new OutsidePackageExtendsClass();
            System.out.println(a2.pub);
            System.out.println(a2.pro);
            //System.out.println(a1.pri);You can't access private methods or variables outside the class in which they are defined.
            //System.out.println(a2.def);
            a2.publicMethod();
            a2.protectedMethod();
            //a1.privateMethod();You can't access private methods or variables outside the class in which they are defined.
            //a2.defaultMethod();
        }
}
