package com.krishsolutions.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Song;
import com.krishsolutions.hibernate.utility.HibernateUtility;

public class UpdateSong {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
	
	 session.beginTransaction();
	 //get data from database and update data to database
	 
	 Song song = session.get(Song.class,1);
	 System.out.println("song :"+song);
	 
	 song.setArtistName("srav");
	
	 session.getTransaction().commit();
	 
	 System.out.println(song);
	}

}
