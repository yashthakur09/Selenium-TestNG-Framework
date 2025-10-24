package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	
	static final By EMAIL=By.id("email");
	static final By PAWSSD=By.id("passwd");
	static final By SIGN_IN_BTN=By.id("SubmitLogin");
	static final By ERROR_MSG_LOCATOR=By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public MyAccountPage doLoginWith(String email, String pass) {
		enterText(EMAIL, email);
		enterText(PAWSSD, pass);
		clickOn(SIGN_IN_BTN);
		MyAccountPage myAccPage=new MyAccountPage(getDriver());
		return myAccPage;	
	}
		
	public LoginPage doLoginWithInvalidCredentials(String emailAddress,String password) {
		enterText(EMAIL, emailAddress);
		enterText(PAWSSD, password);
		clickOn(SIGN_IN_BTN);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}
	
	
	public String getErrorMessage() {
		return getVisibleText(ERROR_MSG_LOCATOR);
	}

}
