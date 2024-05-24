package Day19;


import net.bytebuddy.build.Plugin;
import org.testng.annotations.*;

public class TestNGAnnotations {
   @BeforeSuite
    public void t1(){
       System.out.println("Before Suite");
   }

    @AfterSuite
    public void t2(){
     System.out.println("After Suite");
   }

   @BeforeTest
   public void t3() {
       System.out.println("Before Test");
   }

   @AfterTest
   public void t4(){
       System.out.println("After Test");
   }
//   @BeforeGroups
//   public void t5() {
//       System.out.println("After Suite");
//   }
//    @AfterGroups
//    public void t6() {
//        System.out.println("After Groups");
//    }
   @BeforeClass
   public void t7() {
       System.out.println("Before Class");
   }
    @AfterClass
    public void t8() {
        System.out.println("After Class");
    }
     @BeforeMethod
     public void t9() {
         System.out.println("Before Method");
     }
     @AfterMethod
     public void t10() {
         System.out.println("Before Method");
     }
     @Test(priority = 1)
    public void t13(){
         System.out.println("First Automation Script");
     }
     @Test(priority = 2)
     public void t12(){
         System.out.println("Second Automation Script");
     }
}
