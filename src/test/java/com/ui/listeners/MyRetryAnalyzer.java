package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertyUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	
//	public static final int MAX_ATTEMPS=Integer.parseInt(PropertyUtil.readProperties(Env.QA,"MAX_ATTEMPTS"));
	public static final int MAX_ATTEMPTS=JSONUtility.readJSON(Env.QA).getMAX_ATTEMPS();
	public static int currentAttempts=1;

	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempts<=MAX_ATTEMPTS) {
			currentAttempts++;
			return true;
		}
		return false;
	}

}
