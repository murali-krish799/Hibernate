package com.krishsolutions.hibernate.entity;

import java.io.Serializable;

public class StudentId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	
	private String occupation;


	public StudentId() {
	}


	public StudentId(String name, String occupation) {
		this.name = name;
		this.occupation = occupation;
	}


	@Override
	public String toString() {
		return "StudentId [name=" + name + ", occupation=" + occupation + "]";
	}

}
