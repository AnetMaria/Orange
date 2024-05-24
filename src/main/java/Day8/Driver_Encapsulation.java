package Day8;

public class Driver_Encapsulation {
    public static void main(String[] args) {
        Encapsulation en=new Encapsulation();
        System.out.println(en.getAge());
        en.setAge(20);
        System.out.println(en.getAge());
        System.out.println(en.ageStatus());
    }
}
