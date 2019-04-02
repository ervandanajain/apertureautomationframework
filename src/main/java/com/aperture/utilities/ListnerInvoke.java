package com.aperture.utilities;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerInvoke implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        IRetryAnalyzer retry = result.getMethod().getRetryAnalyzer();
        if (retry == null) {
            return;
        }
        System.out.println("Retrying test " + result.getName() + " with status "
                + getResultStatusName(result.getStatus()) );
        Reporter.log("Retrying test " + result.getName() + " with status "
                + getResultStatusName(result.getStatus()) );
        result.getTestContext().getFailedTests().removeResult(result);
        result.getTestContext().getSkippedTests().removeResult(result);
}
	public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
    }
}