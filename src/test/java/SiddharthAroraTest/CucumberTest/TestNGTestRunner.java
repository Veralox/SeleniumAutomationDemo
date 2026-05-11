package SiddharthAroraTest.CucumberTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/SiddharthAroraTest/CucumberTest",
        glue ="SiddharthAroraTest.StepDefination",monochrome = true,tags = "@Regression",plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
