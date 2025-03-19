package com.krishsolutions.hibernate.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Song;

public class HibernateUtility {

	public static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {

				sessionFactory = new Configuration().configure().addAnnotatedClass(Song.class).buildSessionFactory();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return sessionFactory;
	}

}
