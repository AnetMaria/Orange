package Assignment4;

import Assignment4.Common.GenericBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Assignment5.Commons.Constants.REPORT_PATH;

public class ValidationScreenshots extends BaseClass {
    public static String cleanDate() throws IOException {
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
        String cleanedDate = simpleDate.format(d);
        return cleanedDate;

    }
    public static void getScreenshot(){
        String fileName=null;
        try {
            TakesScreenshot sShot = (TakesScreenshot) driver;
            File img = sShot.getScreenshotAs(OutputType.FILE);
            fileName = System.getProperty("user.dir")+"\\Screenshots\\screenshots_" + cleanDate() + ".png";
            FileUtils.copyFile(img, new File(fileName));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
