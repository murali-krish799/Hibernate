package com.krishsolutions.hibernate.client;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Movie;
import com.krishsolutions.hibernate.entity.Actor;

public class SaveMovies {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Movie.class)
				.addAnnotatedClass(Actor.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		Actor omit_krish = new Actor();
		omit_krish.setActorName( "omit_krish");
		omit_krish.setRemuneration(2222.00);
		
		Actor prabhas = new Actor();
		prabhas.setActorName( "prabhas");
		prabhas.setRemuneration(2222.00);
	
		Movie movie = new Movie();
		movie.setReleaseDate(LocalDateTime.now());
		movie.setName("salaar");
		movie.addActors(omit_krish);
		movie.addActors(prabhas);
		
		Transaction transaction = session.getTransaction();

		transaction.begin();
		
		session.persist(movie);

		transaction.commit();

		session.close();
	}
}
