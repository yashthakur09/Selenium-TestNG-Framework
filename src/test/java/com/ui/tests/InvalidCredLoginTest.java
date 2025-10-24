package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.utility.LoggerUtility;

public class InvalidCredLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String invalidEmail = "yash@yopmail.com";
	private static final String invalidPass = "Yash123";

	@Test(description = "Verify if the correct error message is displayed when user enters invalid username and password", groups = { "e2e", "sanity", "smoke" })
	public void loginTest() {
		assertEquals(
				homePage.goToLoginPage().doLoginWithInvalidCredentials(invalidEmail, invalidPass).getErrorMessage(),
				"Authentication failed.");
	}

}
