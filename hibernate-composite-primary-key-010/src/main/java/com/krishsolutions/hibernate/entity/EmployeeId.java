package com.krishsolutions.hibernate.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable // composite value side
public class EmployeeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_exp")
	private String experience;

	public EmployeeId(String name, String experience) {
		this.name = name;
		this.experience = experience;
	}

	public EmployeeId() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeId [name=" + name + ", experience=" + experience + "]";
	}

}
