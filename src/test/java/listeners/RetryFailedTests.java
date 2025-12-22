package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 2; // retry once

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
        	System.out.println("Executed Retry===================");
            retryCount++;
            return true; // rerun test
        }
        return false;
    }
}
