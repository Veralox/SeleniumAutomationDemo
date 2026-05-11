package SIddharthArora.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepoterNG {

   // ExtentReports extent;
    public static ExtentReports getReportObject()
    {
        String path = System.getProperty("user.dir")+"//reports//extentReportIndex.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Report Demo");
        reporter.config().setDocumentTitle("Automation Test Results");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Siddharth Arora");
        return extent;

    }
}
