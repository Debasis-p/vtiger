package com.crm.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer {
	int count=0;
	int max=2;
	public boolean retry(ITestResult result) {
		
		if(count<max) {
			count++;
			return true;
		}
		return false;
	}
	

}
