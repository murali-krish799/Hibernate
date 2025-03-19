package com.krishsolutions.hibernate.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_di")
	private int id;// value type

	@Column(name = "student_name")
	private String name;// value type

	@Column(name = "student_stream")
	private String stream;// value type

	@Embedded

	@AttributeOverrides({

			@AttributeOverride(name = "address1", column = @Column(name = "home_address1")),

			@AttributeOverride(name = "address2", column = @Column(name = "home_address2")),
			@AttributeOverride(name = "PhoneNo", column = @Column(name = "home_PhoneNo"))

	})
	private Address homeAddress;// composition type

	@Embedded

	@AttributeOverrides({

			@AttributeOverride(name = "address1", column = @Column(name = "office_address1")),

			@AttributeOverride(name = "address2", column = @Column(name = "office_address2")),
			@AttributeOverride(name = "PhoneNo", column = @Column(name = "office_PhoneNo"))

	})
	private Address OfficeAddress;// composition type

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return OfficeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		OfficeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", stream=" + stream + ", homeAddress=" + homeAddress
				+ ", OfficeAddress=" + OfficeAddress + "]";
	}


}
