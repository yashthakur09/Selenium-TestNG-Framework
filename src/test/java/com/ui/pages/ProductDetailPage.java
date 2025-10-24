package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility{
	
	private static  WebDriverWait wait;
	private static final By SIZE_DROPDOWN=By.id("group_1");
	private static final By COLOR_LIST=By.xpath("//ul[@id='color_to_pick_list']//a");
	private static final By ADD_TO_CART=By.name("Submit");
	private static final By CHECKOUT=By.xpath("//a[@title=\"Proceed to checkout\"]");
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailPage changeSize(Size size) {
		selectFromDropdown(SIZE_DROPDOWN,size.toString());
		return new ProductDetailPage(getDriver());
	}
	
	public ProductDetailPage selectColor(int index) {
		clickOn(getAllElements(COLOR_LIST).get(index));
		ProductDetailPage productDetailPage=new ProductDetailPage(getDriver());
		return productDetailPage;
		
	}
	
	public ProductDetailPage addToCart() {
		clickOn(ADD_TO_CART);
		return new ProductDetailPage(getDriver());
	}
	
	public ShoppingCartPage proceedToCheckout() {
		clickOn(CHECKOUT);
		return new ShoppingCartPage(getDriver());
	}
	
}
