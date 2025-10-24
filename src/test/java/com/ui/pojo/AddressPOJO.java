package com.ui.pojo;

public class AddressPOJO {
	
	private String company;
	private String address;
	private String city;
	private String postcode;
	private String phone;
	private String mob;
	private String state;
	private String other;
	
	
	
	public AddressPOJO(String company, String address, String city, String postcode, String phone, String mob,
			String state, String other) {
		super();
		this.company = company;
		this.address = address;
		this.city = city;
		this.postcode = postcode;
		this.phone = phone;
		this.mob = mob;
		this.state = state;
		this.other = other;
	}
	public String getCompany() {
		return company;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getPostcode() {
		return postcode;
	}
	public String getPhone() {
		return phone;
	}
	public String getMob() {
		return mob;
	}
	public String getState() {
		return state;
	}
	public String getOther() {
		return other;
	}
	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", address=" + address + ", city=" + city + ", postcode=" + postcode
				+ ", phone=" + phone + ", mob=" + mob + ", state=" + state + ", other=" + other + "]";
	}
	
	
	
	
}
