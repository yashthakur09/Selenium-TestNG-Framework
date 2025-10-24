package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility {
	
	private static final By PROCESS_ADDRESS=By.name("processAddress");

	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
		
	}

	public ShipmentPage goToShipmentPage() {
		clickOn(PROCESS_ADDRESS);
		
		return new ShipmentPage(getDriver());
	}
	
}
