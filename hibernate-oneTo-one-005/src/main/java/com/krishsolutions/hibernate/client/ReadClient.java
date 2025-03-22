package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Passport;
import com.krishsolutions.hibernate.entity.Student;

public class ReadClient {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Passport.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();
//		Student student = session.get(Student.class, 1);
		
//		System.out.println(student);
	
		Passport passport = session.get(Passport.class, 4);
		System.out.println(passport);
		System.out.println(passport.getStudent());
		
		Student student = session.get(Student.class, 1);
		System.out.println(student);
		
		System.out.println("passport: "+student.getPassport());
		
	transaction.commit();
	session.close();
	}
}
