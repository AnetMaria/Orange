package InheritanceDay7;

public class Part1calc extends BaseCalc {

    int sum(int a, int b){
        return super.addnum(a,b)+10;// using super keyword
    }
    int mulnum(int num1,int num2){
        return num1*num2;
    }
}
