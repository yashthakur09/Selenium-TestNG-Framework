package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakerAddressUtility;

public class AddNewAddressTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private AddressPOJO address;
	
	@BeforeMethod(description="Verify if user login first time into the application")
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("sohoyoy526@gamegta.com", "Slice1234");
		address=FakerAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addNewAddress() {
		String add=myAccountPage.goToAddressPage().saveAddress(address);
		Assert.assertEquals(add.toUpperCase(), "MY ADDRESS");
	}
}
