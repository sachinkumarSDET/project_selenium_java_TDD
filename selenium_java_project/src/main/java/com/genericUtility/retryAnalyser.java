package com.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyser implements IRetryAnalyzer {

	
	/*
	 * @author Sachinkumar_Biradar
	 * iterative run of the failed scripts
	 */
	
	int max_limit=3;
	int count=0;
	@Override
	public boolean retry(ITestResult result) {
		
		if (count<max_limit) {
			count++;
			return true;
		} else {
			return false;
		}
		
	}

	
}
