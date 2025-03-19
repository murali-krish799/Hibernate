package com.krishsolutions.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Song;
import com.krishsolutions.hibernate.utility.HibernateUtility;

public class ReadSong {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
	
//begin transaction is optional for getting data because it is an 
		session.beginTransaction();
		Song song = session.get(Song.class,1);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("song data has been retrieving here..");
System.out.println(song);
	}
}
