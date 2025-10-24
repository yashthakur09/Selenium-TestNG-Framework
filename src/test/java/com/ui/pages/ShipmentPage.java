package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShipmentPage extends BrowserUtility{
	
	private static final By CHECKBOX=By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT=By.cssSelector(".standard-checkout");
	
	
	public ShipmentPage(WebDriver driver) {
		super(driver);
		
	}
	
	public PaymentPage goToPaymentPage() {
		clickOn(CHECKBOX);
		clickOn(PROCEED_TO_CHECKOUT);
		
		return new PaymentPage(getDriver());
	}
	
}
