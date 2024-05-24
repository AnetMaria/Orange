package Day10;

public class Arrays {
    public static void main(String[] args) {
        String[] location = new String[6];
        location[0]="India";
        location[1]="Italy";
        location[2]="Japan";
        location[3]="New Zealand";
        location[4]="Vietnam";
        //How to print a single value
        System.out.println("The third location is: "+location[2]);
        //How to print all the values-using for loop
        for(int i=0;i<location.length;i++)
        {
            System.out.println("The location "+i+" is: "+location[i]);
        }
        //multidimensional array
        String[][][] mArray = new String[3][2][1];
        //how to store values
        mArray[0][0][0]="Kerala";
        mArray[0][1][0]="Tamil Nadu";
        mArray[1][0][0]="Rome";
        mArray[1][1][0]="Tuscany";
        mArray[2][0][0]="Nara";
        mArray[2][1][0]="Okinawa";
       //How to print from one index
        System.out.println("The places in the third location is "+mArray[2][0][0]+" and "+mArray[2][1][0]);
    }
}
