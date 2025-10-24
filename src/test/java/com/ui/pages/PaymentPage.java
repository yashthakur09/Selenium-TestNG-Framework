package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {
	
	private static final By PAYMENT=By.xpath("//a[@title=\"Pay by bank wire\"]");
	private static final By CONFIRM=By.xpath("//p[contains(@class,\"cart_navigation clearfix\")]/button");
	private static final By ALERT_SUCCESS=By.cssSelector(".alert-success");
	
	
	public PaymentPage(WebDriver driver) {
		super(driver);
	
	}
	
	public String makePayment() {
		clickOn(PAYMENT);
		clickOn(CONFIRM);
		
		return getVisibleText(ALERT_SUCCESS);
	}

}
