package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	private boolean isLambdaTest;

	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@Parameters({"browser", "isLambdaTest", "isHeadless"})
	@BeforeMethod(description = "Lauching homepage")
	public void setup(
			@Optional("Chrome") String browser,
			@Optional("false") boolean isLambdaTest, 
			@Optional("true") boolean isHeadless, ITestResult result) {
		this.isLambdaTest=isLambdaTest;
		
		WebDriver lambdaDriver;
		if (isLambdaTest) {
			lambdaDriver=LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage=new HomePage(lambdaDriver);
		} else {
			//Running test on local machine
			logger.info("Launching homepage");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description="Tear down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
		homePage.quit();
	}
	
}
