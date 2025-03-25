package com.krishsolutions.hibernate.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.krishsolutions.hibernate.entity.Movie;
import com.krishsolutions.hibernate.entity.Actor;

public class ReadClient {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Movie.class)
				.addAnnotatedClass(Actor.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();

		Movie movie = session.get(Movie.class, 3);
		System.out.println(movie);
		transaction.commit();
		session.close();
	}
}
