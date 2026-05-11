package SiddharthAroraTest.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    ExtentReports extent;
    @BeforeTest
    public void config()
    {
        String path = System.getProperty("user.dir")+"//reports//extentReportIndex.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Report Demo");
        reporter.config().setDocumentTitle("Automation Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Siddharth Arora");
    }

    @Test
    public void InitialDemo()
    {
        ExtentTest test =extent.createTest("InitialDemo");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/");
        System.out.print(driver.getTitle());
        extent.flush();
        //test.addScreenCaptureFromBase64String(s);


    }
}
