package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {

        if (extent == null) {
        	
         ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport.html");

             spark.config().setReportName("Automation Test Report");
       
            spark.config().setDocumentTitle("Selenium Test Results");
           
            extent = new ExtentReports();
            extent.attachReporter(spark);
          

            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Tester", "Satyam");
        }
        return extent;
    }
}
