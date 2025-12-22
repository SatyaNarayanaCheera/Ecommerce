package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.crm.qa.base.TestBase;

import utils.ExtentManager;
import utils.ScreenshotUtil;


public class ExtentTestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private ExtentReports extent = ExtentManager.getExtent();

    @Override
    public void onTestStart(ITestResult result) {
        
        String testName = result.getMethod().getMethodName();

        if (result.getMethod().getCurrentInvocationCount() > 0) {
            testName += "_Retry_" +
                result.getMethod().getCurrentInvocationCount();
        }
        
        test.set(extent.createTest(testName));
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }
    

    @Override
    public void onTestFailure(ITestResult result) {
    	
    String path = ScreenshotUtil.captureScreenshot(TestBase.getdriver(),result.getMethod().getMethodName());
    
        test.get().fail(result.getThrowable()).addScreenCaptureFromPath(path);
  }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();   // ✅ report generated
    }
}
