package SiddharthAroraTest.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int counter=0;
    int max=1;
    @Override
    public boolean retry(ITestResult result) {
        if(counter<max){
            counter++;
            return  true;
        }
        return false;
    }
}
