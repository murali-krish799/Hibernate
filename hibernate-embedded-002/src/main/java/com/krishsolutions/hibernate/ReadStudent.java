package com.krishsolutions.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.krishsolutions.hibernate.entity.Student;
import com.krishsolutions.hibernate.utility.HibernateUtility;

public class ReadStudent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

		Session openSession = sessionFactory.openSession();

		Transaction transaction = openSession.getTransaction();
		transaction.begin();

		Student student = openSession.get(Student.class, 1);

		transaction.commit();
		openSession.close();
		System.out.println("student details are : " + student);
	}
}
