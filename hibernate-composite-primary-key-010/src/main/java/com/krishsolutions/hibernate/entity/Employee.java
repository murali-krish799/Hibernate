package com.krishsolutions.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")//owening side
public class Employee {

	@EmbeddedId
	private EmployeeId employeeId;
	
	@Column(name="emp_role")
	private String role;
	
	@Column(name="emp_location")
	private String location;

	public EmployeeId getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", role=" + role + ", location=" + location + "]";
	}
	
	
}
