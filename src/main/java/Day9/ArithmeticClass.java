package Day9;

public class ArithmeticClass implements ArithmeticInterface{
    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int sub(int i, int j) {
        return i-j;
    }
    public int mul(int i,int j){
        return i*j;
    }
}
