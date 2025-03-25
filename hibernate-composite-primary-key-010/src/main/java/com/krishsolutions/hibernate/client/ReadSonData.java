package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Student;
import com.krishsolutions.hibernate.entity.StudentId;

public class ReadSonData {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		transaction.begin();

		Student student = session.get(Student.class, new StudentId("krish", "java developer"));
		
		System.out.println(student);
		transaction.commit();

		session.close();

	}

}
