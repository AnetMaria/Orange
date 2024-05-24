package Assignment4.Common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtil {

    private static ExtentReports eReport=null;
    private ReportUtil(){

    }
    public static ExtentReports getReport(){
        if(eReport==null) {
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\Report.html");
            ExtentReports extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }
        return eReport;
    }
}
