package com.krishsolutions.hibernate.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
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

	@ElementCollection
	@CollectionTable(name = "likedItems", joinColumns = @JoinColumn(name = "son_id"))
	@MapKeyColumn(name = "items")
	@Column(name="my_items")
	private Map<String, String> likedItems;

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

	public Map<String, String> getLikedItems() {
		return likedItems;
	}

	public void setLikedItems(Map<String, String> likedItems) {
		this.likedItems = likedItems;
	}

	@Override
	public String toString() {
		return "Son [id=" + id + ", name=" + name + ", nickNames=" + nickNames + ", likedItems=" + likedItems + "]";
	}

}
