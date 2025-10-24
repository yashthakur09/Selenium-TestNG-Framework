package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakerAddressUtility {
		
	public static void main(String[] args) {
		
	}
	
	public static AddressPOJO getFakeAddress() {
		Faker faker=new Faker(Locale.US);
		
		AddressPOJO addressPojo=new AddressPOJO(faker.company().name(),faker.address().fullAddress(),faker.address().city(),faker.numerify("#####"),
				faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(),faker.address().state(),"Save this info");
		
		return addressPojo;
	}
}
