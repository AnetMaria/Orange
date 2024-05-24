package Day15;

public class AgeCalc {
    //creating an exception
    public void ageCalculation(int age) throws Exception {

        if(age<4){
            throw new Exception("Kid Alert!!!");
        } else if (age>4 && age<18) {
            System.out.println("Minor");
        }else{
            System.out.println("Major");
        }
    }
}
