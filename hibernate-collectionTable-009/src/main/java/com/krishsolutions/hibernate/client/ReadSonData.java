package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Son;

public class ReadSonData {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Son.class)
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		transaction.begin();
		Son son = session.get(Son.class, 1);
		System.out.println(son);

		transaction.commit();

		session.close();

	}

}
