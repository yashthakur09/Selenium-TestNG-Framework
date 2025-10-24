package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility{
	
	private static final By PROCEED_TO_CHECKOUT=By.cssSelector(".standard-checkout");

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	public ConfirmAddressPage goToConfirmAddressPage() {
		clickOn(PROCEED_TO_CHECKOUT);
		
		return new ConfirmAddressPage(getDriver());
	}
	
}
