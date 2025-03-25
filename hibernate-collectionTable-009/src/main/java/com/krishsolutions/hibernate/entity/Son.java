package com.krishsolutions.hibernate.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "sons") // plural
public class Son {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "son_id")
	private int id;

	@Column(name = "son_name")
	private String name;

	@ElementCollection
	@CollectionTable(name = "nick_names",

			joinColumns = @JoinColumn(name = "son_id")

	)
	@Column(name = "son_nick_names")
	private List<String> nickNames;

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

	public List<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}

	@Override
	public String toString() {
		return "Son [id=" + id + ", name=" + name + ", nickNames=" + nickNames + "]";
	}

}
