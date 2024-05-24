package Day8;

public class Encapsulation {

    private int age=22;

    public  int getAge() {
        return age;
    }
//People can only get the age, they can't the age.
    public void setAge(int age) {
        this.age = age;
    }
    private String validateAge(){
        if(age>18)
        {
            return "Major";
        }else {
            return "Minor";
        }
    }// we cannot get the output of the above method in our main class because the access is private
    //So we will create a public method and call the private method inside it.
    public String ageStatus(){
        String status=validateAge_New();
        return status;
    }
    private String validateAge_New(){
        if(age>21)
        {
            return "Major";
        }else {
            return "Minor";
        }
    }
}
