package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility{
	private static final By USER_NAME=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");
	private static final By SEARCH_BOX=By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS=By.xpath("//a[@title=\"Add my first address\"]");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getusername() {
		return getVisibleText(USER_NAME);
	}
	
	
	public SearchResultPage searchForProducts(String productName) {
		enterText(SEARCH_BOX, productName);
		enterSpecialKey(SEARCH_BOX, Keys.ENTER);
		
		SearchResultPage searchResultPage=new SearchResultPage(getDriver());
		
		return searchResultPage;
	}
	
	public AddressPage goToAddressPage() {
		clickOn(ADD_NEW_ADDRESS);
		
		AddressPage addressaPage=new AddressPage(getDriver());
		
		return addressaPage;
	}

}
