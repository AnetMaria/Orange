package Assignment5.Commons;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static Assignment5.Commons.Constants.REPORT_PATH;


public class ReportUtility {
    private static ExtentReports eReport=null;
    public static ExtentReports getReport() {
        if (eReport == null) {
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\Report.html");
            eReport= new ExtentReports();
            eReport.attachReporter(extentSparkReporter);
        }
        return eReport;
    }
    public static void pass(ExtentTest test, String details){
        test.pass(details);
    }
    public static void pass(ExtentTest test,String details,String getScreenshotPath) {
        try {
            test.pass(details);
            test.pass("", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath.replace(REPORT_PATH + "\\", "")).build());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void fail(ExtentTest test,String details){
        test.fail(details);
    }
    public static void fail(ExtentTest test,String details,String getScreenshotPath) {
        try {
            test.fail(details);
            test.fail("", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath.replace(REPORT_PATH + "\\", "")).build());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
