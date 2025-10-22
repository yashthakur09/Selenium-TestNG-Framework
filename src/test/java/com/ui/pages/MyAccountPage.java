package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility{
	public static final By USER_NAME=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getusername() {
		return getVisibleText(USER_NAME);
	}

}
