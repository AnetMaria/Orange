package Day19;


import org.testng.annotations.*;

public class TestNGAnnotate {
   @BeforeSuite(groups = {"Smoke","E2E"})
    public void t1(){
       System.out.println("Before Suite");
   }

    @AfterSuite(groups = {"Smoke","E2E"})
    public void t2(){
     System.out.println("After Suite");
   }

   @BeforeTest(groups = {"Smoke","E2E"})
   public void t3() {
       System.out.println("Before Test");
   }

   @AfterTest(groups = {"Smoke","E2E"})
   public void t4(){
       System.out.println("After Test");
   }
   @BeforeClass(groups = {"Smoke","E2E"})
   public void t7() {
       System.out.println("Before Class");
   }
   @AfterClass(groups = {"Smoke","E2E"})
   public void t8() {
        System.out.println("After Class");
    }
    @BeforeMethod(groups = {"Smoke","E2E"})
    public void t9() {
         System.out.println("Before Method");
     }
     @AfterMethod(groups = {"Smoke","E2E"})
     public void t10() {
         System.out.println("Before Method");
     }
     @Test(priority = 1,groups = "Smoke")
    public void t13(){
         System.out.println(" Automation Script 1");
     }
     @Test(priority = 2,groups = "E2E")
     public void t12(){
         System.out.println(" Automation Script 2");
     }
     @BeforeGroups(groups = {"Smoke","E2E"})
    public void t5(){
         System.out.println("Before Group");
     }
     @AfterGroups(groups = {"Smoke","E2E"})
     public void t6(){
         System.out.println("After Group");
     }

}
