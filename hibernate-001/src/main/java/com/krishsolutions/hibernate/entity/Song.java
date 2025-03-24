package com.krishsolutions.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {

	@Id
	@Column(name = "songId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int songId;
	@Column(name = "songName")
	private String songName;
	
	@Column(name = "artistName")
	private String artistName;

	public Song() {
	}

	public Song(int songId, String songName, String artistName) {
		this.songId = songId;
		this.songName = songName;
		this.artistName = artistName;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", artistName=" + artistName + "]";
	}

}
