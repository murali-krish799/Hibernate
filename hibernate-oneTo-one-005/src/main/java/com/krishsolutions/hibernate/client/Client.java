package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Passport;
import com.krishsolutions.hibernate.entity.Student;

public class Client {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Passport.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Passport passport = new Passport();

		passport.setNumber("343343");
		Student student = new Student();
		student.setName("krish");
		student.setOccupation("mec");
		student.setPassport(passport);

		Transaction transaction = session.getTransaction();

		transaction.begin();
//if we are unable cascade.persist means ,we no need to add segregate way
//		session.save(passport);
		session.save(student);
		transaction.commit();

		session.close();
	}
}
