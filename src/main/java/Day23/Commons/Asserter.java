package Day23.Commons;

import com.aventstack.extentreports.ExtentTest;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class Asserter extends SoftAssert {


    private ExtentTest test;
    public Asserter(ExtentTest test){
        this.test=test;
    }

    @Override //This method is already defined in the Assert class
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {

        if (ex.getMessage().contains("#")) {
            LogUtil.error("ex.getMessage().split(\"#\")[0]");
            ReportUtil.fail(test, ex.getMessage().split("#")[0], ex.getMessage().split("#")[1]);
            //If it contains hash means it has to capture Screenshot- there are two methods for the pass method in ReportUtil class
            //One is a pass method with screenshot
            //Other is a pass method without screenshot
            //Any doubts refer ReportUtil class.
        } else{
            ReportUtil.fail(test, ex.getMessage());
        }
    }

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {

        if (assertCommand.getMessage().contains("#")) {
            LogUtil.inform("assertCommand.getMessage().split(\"#\")[0]");
            ReportUtil.fail(test, assertCommand.getMessage().split("#")[0], assertCommand.getMessage().split("#")[1]);
        } else{
            ReportUtil.fail(test, assertCommand.getMessage());
        }
    }

}
