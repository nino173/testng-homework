import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private static final int maxCount = 9;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<maxCount){
            count++;
            return true;
        }
        return false;
    }
}
