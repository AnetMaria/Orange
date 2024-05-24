package Day12;

public class LearnConstructors {
    public int a;
    public int b;

    public LearnConstructors(){
        this.a=25;
        this.b=13;
    }
    public LearnConstructors(int a, int b){
        this.a=a;
        this.b=b;
    }

    public void setVal(int num1,int num2){
        this.a=num1;
        this.b=num2;
    }
    public int sum(){
        return a+b;
    }
}
