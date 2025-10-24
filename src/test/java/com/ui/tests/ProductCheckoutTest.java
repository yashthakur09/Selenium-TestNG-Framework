package com.ui.tests;

import static com.constants.Size.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static SearchResultPage searchResultPage;

	@BeforeMethod(description = "User logs into the application")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("sohoyoy526@gamegta.com", "Slice1234")
				.searchForProducts("Printed Summer Dress");
	}

	@Test(description = "Verify if the logged in user is able to purchase the product", groups = { "e2e", "sanity" })
	public void checkoutTest() {
		String msg=searchResultPage.clikcOnFirstProduct(0).changeSize(M).selectColor(2).addToCart().proceedToCheckout()
				.goToConfirmAddressPage().goToShipmentPage().goToPaymentPage().makePayment();
		
		Assert.assertEquals(msg, "Your order on My Shop is complete.");
	}
}
