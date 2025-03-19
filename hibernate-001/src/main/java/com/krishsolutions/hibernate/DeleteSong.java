package com.krishsolutions.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Song;
import com.krishsolutions.hibernate.utility.HibernateUtility;

public class DeleteSong {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
	
		Song song = new Song(1, "kiss", "krish");
		session.beginTransaction();
		session.remove(song);
		session.getTransaction().commit();
		session.close();
		System.out.println("song data has been saved..");

	}
}
