package Day8;

public class AccessModifiers {
    public int pub=20;
    private int pri=6;
    protected int pro=24;
    int def=13;

    public void publicMethod(){
        System.out.println("This method is public");
    }
    private void privateMethod(){
        System.out.println("This method is private");
    }
    protected void protectedMethod(){
        System.out.println("This method is protected");
    }
    void defaultMethod(){        //no need to specify that the default
        System.out.println("This method is default");
    }

    public static void main(String[] args) {
        AccessModifiers a1 = new AccessModifiers();
        System.out.println(a1.pub);
        System.out.println(a1.pro);
        System.out.println(a1.pri);
        System.out.println(a1.def);
        a1.publicMethod();
        a1.protectedMethod();
        a1.privateMethod();
        a1.defaultMethod();

    }
}
