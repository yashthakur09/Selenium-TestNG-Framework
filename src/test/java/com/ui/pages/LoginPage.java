package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	
	static final By EMAIL=By.id("email");
	static final By PAWSSD=By.id("passwd");
	static final By SIGN_IN_BTN=By.id("SubmitLogin");

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
	

}
