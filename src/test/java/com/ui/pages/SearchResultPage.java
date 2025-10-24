package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE = By.xpath("//span[@class=\"lighter\"]");
	private static final By PRODUCT_LISTS = By.xpath("//h5[@itemprop=\"name\"]/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);

	}

	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE);
	}
	
	public boolean isSearchTermPresent(String text) {
		List<String> textList=Arrays.asList(text.toLowerCase().split(" "));
		List<String>productList=getAllVisibleText(PRODUCT_LISTS);
		boolean result=productList.stream()
		.anyMatch(name -> (textList.stream().anyMatch(name.toLowerCase()::contains)));
		
		return result;
	}
	
	public ProductDetailPage clikcOnFirstProduct(int index) {
		clickOn(getAllElements(PRODUCT_LISTS).get(index));
		ProductDetailPage productDetailPage=new ProductDetailPage(getDriver());
		return productDetailPage;
		
	}
}
