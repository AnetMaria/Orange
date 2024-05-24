package Day9;

public class ArithmeticClass2 implements ArithmeticInterface{
    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int sub(int i, int j) {
        return i-j;
    }
    public int div(int i,int j){
        return i/j;
    }
}
