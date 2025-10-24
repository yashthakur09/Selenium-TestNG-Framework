package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class SearchProductTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private static final String searchText="Mens Shoe";
	
	@BeforeMethod(description="Verify if valid user logs in")
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("sohoyoy526@gamegta.com", "Slice1234");
	}
	
	
	@Test(description= "Verify if the logged in user able to search fro a product and correct search result should be displayed",
			groups= {"e2e","sanity"})
	public void verifyProductSearchTest() {
		boolean res=myAccountPage.searchForProducts(searchText).isSearchTermPresent(searchText);
		Assert.assertEquals(res, true);
		
	}

}
