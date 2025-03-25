package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Customer;
import com.krishsolutions.hibernate.entity.CustomerId;
import com.krishsolutions.hibernate.entity.Order;
import com.krishsolutions.hibernate.entity.Student;
import com.krishsolutions.hibernate.entity.StudentId;

public class ReadCustomerData {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		transaction.begin();

		Customer customer = session.get(Customer.class, new CustomerId("krish", "300.00"));

		System.out.println("customer data >>>>>> " + customer);
		transaction.commit();

		session.close();

	}

}
