package com.aperture.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int counter=0;
	int retryLimit=1;
	
	public boolean retry(ITestResult result) {
		if(counter<retryLimit)
		{
            counter++;
			return true;
		}
		return false;
	}
	

}
