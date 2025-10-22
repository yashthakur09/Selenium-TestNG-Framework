package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;
import com.utility.LoggerUtility;


@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest3 extends TestBase {
	
	Logger logger=LoggerUtility.getLogger(this.getClass());

//	@Test(description = "Verify login functionality", groups = { "e2e", "sanity" }, dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
//	public void login(User user) {
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getusername(),
//				"Yash Thakur");
//	}
	
//	@Test(description = "Verify login functionality", groups = { "e2e", "sanity" }, dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginCSVTestDataProvider")
//	public void login2(User user) {
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getusername(),
//				"Yash Thakur");
//	}
//	
	@Test(description = "Verify login functionality", groups = { "e2e", "sanity" }, dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginExcelTestDataProvider",retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class)
	public void login3(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getusername(),
				"Yash1 Thakur");
	}

}
