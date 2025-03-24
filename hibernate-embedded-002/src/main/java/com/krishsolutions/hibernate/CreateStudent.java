package com.krishsolutions.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.krishsolutions.hibernate.entity.Address;
import com.krishsolutions.hibernate.entity.Student;
import com.krishsolutions.hibernate.utility.HibernateUtility;

public class CreateStudent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.getTransaction();

			Address homeAddress = new Address();
			homeAddress.setAddress1("my first address-2");
			homeAddress.setAddress2("second address-2");
			homeAddress.setPhoneNo("454567-2");
			Address officeAddress = new Address();
			officeAddress.setAddress1("my first address-2");
			officeAddress.setAddress2("second address-2");
			officeAddress.setPhoneNo("454567-2");
			Student student = new Student();
			student.setName("krish-2");
			student.setStream("mechanical-2");
			student.setHomeAddress(homeAddress);
			student.setOfficeAddress(officeAddress);
			transaction.begin();
			session.persist(student);
			transaction.commit();
			session.close();
			System.out.println("student table has been created..");
		}
	}
}
