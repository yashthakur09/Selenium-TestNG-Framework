package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {
	
	private static final By COMPANY=By.id("company");
	private static final By ADDRESS=By.id("address1");
	private static final By CITY=By.id("city");
	private static final By ZIPCODE=By.id("postcode");
	private static final By PHONE_NUM=By.id("phone");
	private static final By STATE=By.id("id_state");
	private static final By MOB_NUM=By.id("phone_mobile");
	private static final By OTHER=By.id("other");
	private static final By SUBMIT_ADDRESS=By.id("submitAddress");
	private static final By TAG=By.tagName("h3");
	
	public AddressPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String saveAddress(AddressPOJO addPOJO) {
		enterText(COMPANY,addPOJO.getCompany());
		enterText(ADDRESS,addPOJO.getAddress());
		enterText(CITY,addPOJO.getCity());
		enterText(ZIPCODE,addPOJO.getPostcode());
		enterText(PHONE_NUM,addPOJO.getPhone());
		enterText(MOB_NUM,addPOJO.getMob());
		enterText(OTHER, addPOJO.getOther());
		selectFromDropdown(STATE,addPOJO.getState());
		
		clickOn(SUBMIT_ADDRESS);
		
		return getVisibleText(TAG);
	}
	
	

}
