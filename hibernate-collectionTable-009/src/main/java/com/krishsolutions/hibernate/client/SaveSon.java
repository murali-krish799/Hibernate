package com.krishsolutions.hibernate.client;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Son;

public class SaveSon {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Son.class)
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		transaction.begin();
		
		Son son= new Son();
		son.setName("omit_krish");
		son.setNickNames(Arrays.asList("krish","kanayya","nanna"));

		session.persist(son);
		transaction.commit();

		session.close();
	}
}
