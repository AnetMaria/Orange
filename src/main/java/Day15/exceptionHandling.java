package Day15;

public class exceptionHandling {

    public static void main(String[] args) {
        //checked exception
        //Thread.sleep(5000);

        //unchecked exception
//        String[] str = new String[4];
//        str[3]="Anet";
//        str[4]="Maria";
//        System.out.println(str[3]);
        //System.out.println(str[4]);
//        AgeCalc obj = new AgeCalc();
//        obj.ageCalculation(3);

        //how to handle exception using try -catch
        AgeCalc ageC = new AgeCalc();
        try{
            ageC.ageCalculation(3);
        }catch(Exception e){
            System.out.println("The exception is "+e.toString());
//            e.printStackTrace();
        }finally {
            System.out.println("Will get executed anyways");
        }
    System.out.println("End of program");
    }
}
