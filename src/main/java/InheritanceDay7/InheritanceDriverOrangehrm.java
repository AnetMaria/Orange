package InheritanceDay7;
//main class-executable one
public class InheritanceDriverOrangehrm  {
    public static void main(String[] args) {
        Script_Inheritance object = new Script_Inheritance();
        object.launchApp("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String error_msg=object.enterExtract("Rohit Sharma","hitman101");
        System.out.println("The error message is: "+error_msg);//find how to return that error msg and print it
        object.tearDown();

        Bing_Inheritance object1=new Bing_Inheritance();
        object1.launchApp("https://www.bing.com/");
        object1.search("Weather");
        object1.tearDown();


    }
}
