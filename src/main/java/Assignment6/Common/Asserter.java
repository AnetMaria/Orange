package Assignment6.Common;

import Assignment6.Common.LogUtil;
import Assignment6.Common.ReportUtility;
import com.aventstack.extentreports.ExtentTest;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class Asserter extends SoftAssert {


    private ExtentTest test;
    public Asserter(ExtentTest test){
        this.test=test;
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
//For Fail Scenario
        if (ex.getMessage().contains("#")) {
            LogUtil.error(ex.getMessage().split("#")[0]);
            ReportUtility.fail(test,ex.getMessage().split("#")[0],ex.getMessage().split("#")[1]);
        } else{
            LogUtil.error(ex.getMessage());
            ReportUtility.fail(test,ex.getMessage());
        }
    }

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
//For Pass Scenario
        if (assertCommand.getMessage().contains("#")) {
            LogUtil.inform(assertCommand.getMessage().split("#")[0]);
            ReportUtility.pass(test, assertCommand.getMessage().split("#")[0], assertCommand.getMessage().split("#")[1]);
        } else{
            LogUtil.inform(assertCommand.getMessage());
            ReportUtility.pass(test, assertCommand.getMessage());
        }
    }

}
