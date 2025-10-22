package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility{
	
	public static final By SIGN_IN_BUTTON=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	public HomePage(Browser browser, boolean bool) {
		super(browser, bool);	
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		maximizeWindow();
	}
	
	public HomePage(WebDriver driver) {
		super(driver);	
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		maximizeWindow();
	}
	
	public LoginPage goToLoginPage() {
		logger.info("trying to perfrom login on login page");
		clickOn(SIGN_IN_BUTTON);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}

	public void quit() {
		getDriver().quit();	
	}
	
}
