package com.krishsolutions.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Song;
import com.krishsolutions.hibernate.utility.HibernateUtility;

public class CreateSong {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();

			Song song = new Song(4, "kiss", "krish");//transient state
			session.beginTransaction();
			session.save(song);//persistent state
			session.getTransaction().commit();
			boolean contains = session.contains(song);
			System.out.println("is contain : "+contains);
			session.detach(song);//detached state
			boolean contains2 = session.contains(song);
			System.out.println("is contain : "+contains2);
			System.out.println("song data has been saved..");
		}
	}
}
