package com.krishsolutions.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable // composite value type or embedded value type term of jpa
public class Address {
	
	private String address1;
	private String address2;
	private String PhoneNo;

	public Address() {
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", address2=" + address2 + ", PhoneNo=" + PhoneNo + "]";
	}
	
}