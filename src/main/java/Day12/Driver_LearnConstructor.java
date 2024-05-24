package Day12;

public class Driver_LearnConstructor {
    public static void main(String[] args) {
        LearnConstructors lConst = new LearnConstructors();//LearnConstructors is also a method that has the same name as the class.
        lConst.setVal(34,81);
        System.out.println(lConst.sum());
        //using constructors
        //parameterized constructor
        LearnConstructors lConst1 = new LearnConstructors(9, 12);
        System.out.println(lConst1.sum());
        //default constructor
        LearnConstructors lConst2 = new LearnConstructors();
        System.out.println(lConst2.sum());
    }

}
